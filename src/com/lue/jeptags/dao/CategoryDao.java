package com.lue.jeptags.dao;

import com.google.gson.Gson;
import com.lue.jeptags.entity.SubCategory;
import com.lue.jeptags.entity.SubCategoryList;
import com.lue.jeptags.json.reponse.CategoryModall;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Lue
 */
public class CategoryDao {

   
    private static  CategoryModall catgModel=new CategoryModall();
    private String categoryId = "";

   /**
    * 
    * @return 
    */
    public CategoryModall getCategory() {
        // Just Fetch first time
        if(catgModel.getCatId1().size()<2){
        
        new Runnable() {
            @Override
            public void run() {

                try {

                    String api_url = UrlProperties.getProperties().getProperty("get_categories");
                    HttpClient client = HttpClientBuilder.create().build();

                    HttpGet get = new HttpGet(api_url);

                    get.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

                    HttpResponse response = client.execute(get);
                    String result = EntityUtils.toString(response.getEntity());

                    // CONVERT RESPONSE STRING TO JSON ARRAY
                    JSONArray ja = new JSONArray(result);

                    int n = ja.length();
                    for (int i = 0; i < n; i++) {
                        // GET INDIVIDUAL JSON OBJECT FROM JSON ARRAY
                        JSONObject jo = ja.getJSONObject(i);

                        // RETRIEVE EACH JSON OBJECT'S FIELDS
                        String Id = jo.getString("entity_id");
                        String name = jo.getString("name");

                        // ADD DATA TO LIST
                        catgModel.getCatId1().add(Id);
                        catgModel.getCatName().add(name);
                    }
                } catch (JSONException | IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();
        }
        return catgModel;

    }

    /**
     *
     * @param catId
     * @return List
     */
    public List getSubCategoryList(String catId) {
        List<String> subCat = new ArrayList<>();
        new Runnable() {
            @Override
            public void run() {
                try {
                    categoryId = catId;
                    String api_url = UrlProperties.getProperties().getProperty("get_subcategories");
                    HttpClient client = HttpClientBuilder.create().build();

                    HttpPost post = new HttpPost(api_url);

                    post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                    JSONObject objtoken = new JSONObject();
                    objtoken.put("category_id", categoryId);
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
                    SubCategoryList subCategoryList = gson.fromJson(result.toString(), SubCategoryList.class);
                    if (!subCategoryList.isError()) {
                        List<SubCategory> subcategory = subCategoryList.getMessage();
                        for (SubCategory subcategory1 : subcategory) {
                            subCat.add(subcategory1.getSubcat_id());
                            subCat.add(subcategory1.getName());
                        }
                    }
                } catch (JSONException | IOException ex) {
                    Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();
        return subCat;
    }
}