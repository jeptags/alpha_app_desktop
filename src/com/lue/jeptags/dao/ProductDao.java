package com.lue.jeptags.dao;

import com.lue.jeptags.entity.EditProduct;
import com.lue.jeptags.entity.EditProductList;
import com.lue.jeptags.entity.Product;
import com.lue.jeptags.entity.ProductList;
import java.util.Arrays;
import com.google.gson.Gson;
import com.lue.jeptags.entity.SellerStoreResponse;
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
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author lue
 */
public class ProductDao {

    List<String> products = new ArrayList<>();
    boolean status;
    List<EditProduct> productDetail = new ArrayList<>();
    List<Product> product = new ArrayList<>();
    EditProductList editProductDetails;
    public static String latitude;
    public static String longitude;

    List prodDetail = new ArrayList();
    private final String seller_id = LoginValidation.SELLER_ID;

    /**
     *
     * @param brandValue
     * @param prodCondition
     * @param productName
     * @param category
     * @param description
     * @param weight
     * @param price
     * @param quantity
     * @param address
     * @param mode
     * @param image64
     * @return
     */
    public boolean uploadProduct(String brandValue, String prodCondition, String productName, String category, String description, String weight, String price, String quantity, String address, String mode, String image64) {
        new Runnable() {
            String api_url;
            String seller_id;

            @Override
            public void run() {
                try {
                    if (LoginValidation.ROLE.equals("admin")) {
                        api_url = UrlProperties.getProperties().getProperty("add_product_admin");
                    } else if (LoginValidation.ROLE.equals("seller")) {
                        api_url = UrlProperties.getProperties().getProperty("add_products");
                    }
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpPost post = new HttpPost(api_url);
                    post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                    JSONObject objtoken = new JSONObject();

                    objtoken.put("seller_id", LoginValidation.SELLER_ID);
                    objtoken.put("name", productName);
                    objtoken.put("brand", brandValue);
                    objtoken.put("condition", prodCondition);
                    objtoken.put("category", category);
                    objtoken.put("description", description);
                    objtoken.put("weight", weight);
                    objtoken.put("price", price);
                    objtoken.put("qty", quantity);
                    objtoken.put("address", address);
                    objtoken.put("mode", mode);
                    objtoken.put("image", image64);

                    StringEntity entity = new StringEntity(objtoken.toString());
                    post.setEntity(entity);
                    HttpResponse response = client.execute(post);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    StringBuffer result = new StringBuffer();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    status = result.toString().contains("\"error\":false");
                } catch (IOException ex) {
                    System.out.println("Exception during Uploading Products:- " + ex.toString());
                } catch (JSONException ex) {
//                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Json Exception during Uploading Products:- " + ex.toString());

                }
            }
        }.run();

        return status;
    }

    /**
     *
     * @return
     */
    public List<Product> getProducts() {
        new Runnable() {
            @Override
            public void run() {
                try {
                    String api_url = UrlProperties.getProperties().getProperty("seller_products");
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
                        ProductList productList = gson.fromJson(result.toString(), ProductList.class);

                        product = productList.getMessage();
                    }
                } catch (JSONException | IOException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();

        return product;
    }

    /**
     *
     * @param product_id
     * @return
     */
    public EditProductList getProductDetail(String product_id) {
        new Runnable() {
            @Override
            public void run() {
                try {
                    String api_uri = UrlProperties.getProperties().getProperty("edit_products");
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpPost post = new HttpPost(api_uri);

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
                         editProductDetails = gson.fromJson(result.toString(), EditProductList.class);
//                        prodDetail.add(product_id);
//                        prodDetail.add(lgr.getMessage().getName());
//                        prodDetail.add(lgr.getMessage().getCategory());
//                        prodDetail.add(lgr.getMessage().getSubcategory());
//                        prodDetail.add(lgr.getMessage().getDescription());
//                        prodDetail.add(lgr.getMessage().getWeight());
//                        prodDetail.add(lgr.getMessage().getPrice());
//                        prodDetail.add(lgr.getMessage().getQty());
//
//                        String img = (Arrays.toString(lgr.getMessage().getImage()));
//                        prodDetail.add(img);
//                        prodDetail.add(lgr.getMessage().getBrand_name());
                    }
                     if(latitude==null){
                    getLatLong();
                     }
                } catch (IOException | JSONException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();
        return editProductDetails;

    }

    /**
     *
     * @param productId
     * @param productName
     * @param category
     * @param subCategory
     * @param description
     * @param weight
     * @param price
     * @param quantity
     * @param image64
     * @return
     */
    public boolean updateProduct(String productId, String productName, String category, String subCategory, String description, String weight, String price, String quantity, String image64) {
        new Runnable() {
            @Override
            public void run() {
                try {
                    String api_url = UrlProperties.getProperties().getProperty("update_products");
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpPost post = new HttpPost(api_url);
                    post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                    JSONObject objtoken = new JSONObject();
                    objtoken.put("product_id", productId);
                    objtoken.put("name", productName);
                    objtoken.put("category", category);
                    objtoken.put("subcategory", subCategory);
                    objtoken.put("description", description);
                    objtoken.put("weight", weight);
                    objtoken.put("price", price);
                    objtoken.put("qty", quantity);
                    objtoken.put("image", image64);
                    StringEntity entity = new StringEntity(objtoken.toString());
                    post.setEntity(entity);
                    HttpResponse response = client.execute(post);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    StringBuffer result = new StringBuffer();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    status = result.toString().contains("\"error\":true");
                } catch (IOException ex) {
                    System.out.println("Exception during updating products:- " + ex.toString());
                } catch (JSONException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();

        return status;
    }

    public void getLatLong() {
        try {
 
            String api_url = UrlProperties.getProperties().getProperty("get_seller_store_address");
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
            if (!result.toString().contains("\"error\":true")) {
                Gson gson = new Gson();
                SellerStoreResponse seller = gson.fromJson(result.toString(), SellerStoreResponse.class);
//                prodDetail.add(seller.getMessage().getGeo_latitude());
//                prodDetail.add(seller.getMessage().getGeo_longitude());
                latitude=seller.getMessage().getGeo_latitude();
                longitude=seller.getMessage().getGeo_longitude();

            }
        } catch (JSONException | IOException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public boolean deleteProduct(String productId) {
        new Runnable() {
            @Override
            public void run() {
                try {
                    String api_url = UrlProperties.getProperties().getProperty("delete_products");
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpPost post = new HttpPost(api_url);
                    post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                    JSONObject objtoken = new JSONObject();
                    objtoken.put("product_id", productId);
                    StringEntity entity = new StringEntity(objtoken.toString());
                    post.setEntity(entity);
                    HttpResponse response = client.execute(post);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    StringBuffer result = new StringBuffer();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    status = result.toString().contains("\"error\":false");
                } catch (IOException ex) {
                    System.out.println("Exception during deleting Product:- " + ex.toString());
                } catch (JSONException ex) {
                    Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();

        return status;
    }
}
