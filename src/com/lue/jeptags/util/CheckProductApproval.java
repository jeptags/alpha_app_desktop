package com.lue.jeptags.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lue.jeptags.entity.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class CheckProductApproval {

    boolean flag;

    public Boolean productApproved(String product_id) {
        new Runnable() {
            @Override
            public void run() {
                try {
                    String api_url = UrlProperties.getProperties().getProperty("product_status");
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpPost post = new HttpPost(api_url);

                    post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                    JSONObject objtoken = new JSONObject();
                    objtoken.put("product_id", product_id);
                    StringEntity entity = new StringEntity(objtoken.toString());
                    post.setEntity(entity);
                    HttpResponse response = client.execute(post);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    StringBuilder result = new StringBuilder();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    Gson gson = new Gson();
                    Response res = gson.fromJson(result.toString(), Response.class);
                    flag = !res.isError();
                } catch (JsonSyntaxException | IOException | UnsupportedOperationException | JSONException ex) {
//                    Logger.getLogger(CheckProductApproval.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Exception-- " + ex.toString());

                }
            }
        }.run();
        return flag;
    }
}
