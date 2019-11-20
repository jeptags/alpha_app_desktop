package com.lue.jeptags.util;

import com.google.gson.Gson;
import com.lue.jeptags.entity.LoginResponseMessage;
import com.lue.jeptags.entity.Response;
import com.lue.jeptags.entity.Role;
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
public class LoginValidation {

    public static String SELLER_ID;
    public static String ROLE;
    private boolean status;
    LoginSellerResponse r;

    public boolean userValidation(String username, String password) {

        new Runnable() {
            @Override
            public void run() {
                try {
                    String api_url = UrlProperties.properties.getProperty("login");

                    HttpClient client = HttpClientBuilder.create().build();
                    HttpPost post = new HttpPost(api_url);

                    post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                    JSONObject objtoken = new JSONObject();
                    objtoken.put("username", username);
                    objtoken.put("password", password);
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
                    status = res.isError();
                    if (!status) {

                        Role role = gson.fromJson(result.toString(), Role.class);
                        ROLE = role.getRole();
                        if (ROLE.equals("seller")) {
                            LoginResponseMessage lgm = gson.fromJson(result.toString(), LoginResponseMessage.class);
                            SELLER_ID = lgm.getMessage().getEntity_id();
                        }
                    }
                } catch (JSONException | IOException ex) {
//                    Logger.getLogger(LoginValidation.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("JSONException/IOException --- " + ex);
                }
            }
        }
                .run();
        return status;
    }

}
