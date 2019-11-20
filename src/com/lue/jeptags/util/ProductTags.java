package com.lue.jeptags.util;

import com.google.gson.Gson;
import com.lue.jeptags.entity.GetProductTags;
import com.lue.jeptags.entity.GetProductsTagsList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
public class ProductTags {

    /**
     * 
     * @param product_id
     * @return 
     */
    public List getProductTags(String product_id) {
        List<String> prodTags = new ArrayList<>();

        new Runnable() {
            @Override
            public void run() {
                try {
                    String api_url = UrlProperties.getProperties().getProperty("get_product_tags");
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
                    if (result.toString().contains("\"error\":false")) {
                        Gson gson = new Gson();
                        GetProductsTagsList productTagList = gson.fromJson(result.toString(), GetProductsTagsList.class);
                        if (!productTagList.isError()) {
                            List<GetProductTags> tags = productTagList.getMessage();
                            for (GetProductTags tags1 : tags) {
                                prodTags.add(tags1.getJeptag_id());
                                prodTags.add(tags1.getUpdated_at());
                            }
                        }
                    }
                } catch (JSONException | IOException ex) {
                    System.out.println("Exception-- "+ex.toString());
//                    Logger.getLogger(ProductTags.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();
        return prodTags;
    }

}
