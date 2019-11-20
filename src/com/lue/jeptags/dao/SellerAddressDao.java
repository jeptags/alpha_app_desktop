package com.lue.jeptags.dao;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lue.jeptags.entity.SellerStoreAddress;
import com.lue.jeptags.entity.SellerStoreResponse;
import com.lue.jeptags.util.LoginValidation;
import com.lue.jeptags.util.UrlProperties;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
 * @author Lue
 */
public class SellerAddressDao {

    private boolean status;
    private SellerStoreAddress ssa = new SellerStoreAddress();
    private static  Boolean flag=null;
    private String seller_id = LoginValidation.SELLER_ID;
    private static Boolean storeAddressStatus;

    /**
     *
     * @return
     */
    public Boolean checkSellerDefaultAddress() {
        if(flag==null){
        new Runnable() {
            @Override
            public void run() {
                try {
                    String api_url = UrlProperties.getProperties().getProperty("check_seller_default_address");
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
                    flag = result.toString().contains("\"error\":false");
                } catch (JsonSyntaxException | IOException | UnsupportedOperationException | JSONException ex) {
                    Logger.getLogger(SellerAddressDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();
        }
        return flag;
    }

    public Boolean checkStoreAddressStatus() {
        if(storeAddressStatus==null){
        new Runnable() {
            @Override
            public void run() {
                try {
                    String api_url = UrlProperties.getProperties().getProperty("check_store_address_status");
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
                    storeAddressStatus = result.toString().contains("\"error\":false");
                } catch (JsonSyntaxException | IOException | UnsupportedOperationException | JSONException ex) {
                    Logger.getLogger(SellerAddressDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();
        }
        return storeAddressStatus;
    }

    /**
     *
     * @param firstname
     * @param lastname
     * @param street
     * @param city
     * @param region
     * @param country_id
     * @param postal_code
     * @param telephone
     * @return
     */
    public boolean addAddress(String firstname, String lastname, String street, String city, String region, String country_id, String postal_code, String telephone) {
        new Runnable() {
            @Override
            public void run() {
                try {

                    String api_url = UrlProperties.getProperties().getProperty("add_store_address");
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpPost post = new HttpPost(api_url);

                    post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                    JSONObject objtoken = new JSONObject();
                    objtoken.put("firstname", firstname);
                    objtoken.put("lastname", lastname);
                    objtoken.put("street", street);
                    objtoken.put("city", city);
                    objtoken.put("region", region);
                    objtoken.put("country_id", country_id);
                    objtoken.put("postcode", postal_code);
                    objtoken.put("telephone", telephone);

                    StringEntity entity = new StringEntity(objtoken.toString());
                    post.setEntity(entity);
                    HttpResponse response = client.execute(post);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    StringBuffer result = new StringBuffer();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    if (!result.toString().contains("\"error\":true")) {
                        status = false;
                    } else {
                        status = true;
                    }
                } catch (IOException ex) {
                    System.out.println("Exception during Uploading Products:- " + ex.toString());
                } catch (JSONException ex) {
                    Logger.getLogger(SellerAddressDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();

        return status;
    }

    /**
     *
     * @param firstname
     * @param lastname
     * @param street
     * @param city
     * @param region
     * @param country_id
     * @param postal_code
     * @param telephone
     * @param latitude
     * @param longitude
     * @return
     */
    public boolean addStoreAddress(String firstname, String lastname, String street, String city, String region, String country_id, String postal_code, String telephone, String latitude, String longitude) {
        new Runnable() {
            @Override
            public void run() {
                try {

                    String api_url = UrlProperties.getProperties().getProperty("add_store_address");
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpPost post = new HttpPost(api_url);

                    post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                    JSONObject objtoken = new JSONObject();
                    objtoken.put("seller_id", seller_id);
                    objtoken.put("firstname", firstname);
                    objtoken.put("lastname", lastname);
                    objtoken.put("street", street);
                    objtoken.put("city", city);
                    objtoken.put("state", region);
                    objtoken.put("country_id", country_id);
                    objtoken.put("postcode", postal_code);
                    objtoken.put("telephone", telephone);
                    objtoken.put("latitude", latitude);
                    objtoken.put("longitude", longitude);

                    StringEntity entity = new StringEntity(objtoken.toString());
                    post.setEntity(entity);
                    HttpResponse response = client.execute(post);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    StringBuffer result = new StringBuffer();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    if (result.toString().contains("\"error\":true")) {
                        status = false;
//               
                    } else {
                        status = true;
                    }
                } catch (IOException ex) {
                    System.out.println("Exception during Uploading Products:- " + ex.toString());
                } catch (JSONException ex) {
                    Logger.getLogger(SellerAddressDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();

        return status;
    }

    public SellerStoreAddress getSellerStoreAddress() {

        new Runnable() {
            @Override
            public void run() {
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
                        ssa = seller.getMessage();
                    }
                } catch (JSONException | IOException ex) {
                    System.out.println("Exception  \n" + ex.toString());
                }
            }
        }.run();
        return ssa;
    }

}
