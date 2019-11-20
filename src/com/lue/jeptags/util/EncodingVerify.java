package com.lue.jeptags.util;

import com.google.gson.Gson;
import com.lue.jeptags.entity.EncodeVerify;
import com.lue.jeptags.entity.EncodeVerify1;
import com.lue.jeptags.entity.EncodeVerifyResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author lue
 */
public class EncodingVerify {

    private final List<String> message = new ArrayList<>();

    public EncodingVerify() {

    }
    public List verify(String seller_id, String tag_id, String product_id, String latitude, String longitude) {
        new Runnable() {
            String api_url;

            @Override
            public void run() {
                try {

                    if (LoginValidation.ROLE.equals("admin")) {
                        api_url = UrlProperties.getProperties().getProperty("encoding_verify_admin");
                    } else if (LoginValidation.ROLE.equals("seller")) {
                        api_url = UrlProperties.getProperties().getProperty("encoding_verify");
                    }
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpPost post = new HttpPost(api_url);
                    post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                    JSONObject objtoken = new JSONObject();
                    objtoken.put("seller_id", seller_id);
                    objtoken.put("tag_id", tag_id);
                    objtoken.put("product_id", product_id);
                    objtoken.put("latitude", latitude);
                    objtoken.put("longitude", longitude);
//                   
                    StringEntity entity = new StringEntity(objtoken.toString());
                    post.setEntity(entity);

                    HttpResponse response = client.execute(post);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    StringBuilder result = new StringBuilder();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    System.out.println("Result -- "+result);
                    Gson gson = new Gson();
                    if (result.toString().contains("\"error\":true")) {
                        EncodeVerify1 env = gson.fromJson(result.toString(), EncodeVerify1.class);
                        message.add("0");
                        message.add(env.getMessage());
                    } else {
                        EncodeVerifyResponse env = gson.fromJson(result.toString(), EncodeVerifyResponse.class);
                        List<EncodeVerify> env1 = env.getMessage();
                        for (EncodeVerify enf : env1) {
                            message.add("1");
                            message.add(enf.getJeptag_id());
                        }
                    }
                } catch (JSONException | IOException ex) {
                    Logger.getLogger(EncodingVerify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
                .run();
        return message;
    }
}
