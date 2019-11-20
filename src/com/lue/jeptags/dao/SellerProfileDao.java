package com.lue.jeptags.dao;

import com.google.gson.Gson;
import com.lue.jeptags.entity.SellerListResponse;
import com.lue.jeptags.entity.SellerProfile;
import com.lue.jeptags.entity.SellerProfileResponse;
import com.lue.jeptags.entity.Sellers;
import com.lue.jeptags.util.LoginValidation;
import com.lue.jeptags.util.UrlProperties;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Lue
 */
public class SellerProfileDao {

    private String seller_id = LoginValidation.SELLER_ID;
    List<Sellers> sellers = new ArrayList<>();
    SellerProfile sp = new SellerProfile();

    /**
     *
     * @return
     */
    public SellerProfile getSellerProfile() {
        new Runnable() {
            @Override
            public void run() {
                try {

                    String api_url = UrlProperties.getProperties().getProperty("edit_sellers");
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpPost post = new HttpPost(api_url);
                    post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                    JSONObject objtoken = new JSONObject();
                    objtoken.put("seller_id", seller_id);

                    StringEntity entity = new StringEntity(objtoken.toString());
                    post.setEntity(entity);
                    HttpResponse response = client.execute(post);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    StringBuilder result = new StringBuilder();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    if (result.toString().contains("\"error\":false")) {

                        Gson gson = new Gson();

                        SellerProfileResponse spr = gson.fromJson(result.toString(), SellerProfileResponse.class);
                        sp = spr.getMessage();
                    }
                } catch (JSONException | IOException ex) {
                    Logger.getLogger(SellerProfileDao.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
                .run();
        return sp;
    }

    /**
     *
     * @return List
     */
    public List<Sellers> getSellerList() {

        new Runnable() {
            @Override
            public void run() {
                try {
                    String api_url = UrlProperties.getProperties().getProperty("get_seller_list");
                    HttpClient client = HttpClientBuilder.create().build();

                    HttpGet get = new HttpGet(api_url);

                    get.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

                    HttpResponse response = client.execute(get);
                    String result = EntityUtils.toString(response.getEntity());

                    Gson gson = new Gson();
                    SellerListResponse slr = gson.fromJson(result, SellerListResponse.class);

                    if (!slr.isError()) {
                        sellers = slr.getMessage();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();
        return sellers;
    }

}
