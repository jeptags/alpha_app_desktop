package com.lue.jeptags.dao;

import com.google.gson.Gson;
import com.lue.jeptags.entity.Brand;
import com.lue.jeptags.entity.BrandList;
import com.lue.jeptags.json.reponse.BrandModal;
import com.lue.jeptags.util.UrlProperties;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author lue
 */
public class BrandDao {

    private static BrandModal brandModal=new BrandModal();
    
    /**
     *
     * @return
     */
    public BrandModal getBrand() {
       if(brandModal.getBrandId().size()<2){
        new Runnable() {
            @Override
            public void run() {
                try {
                   
                    String api_url =UrlProperties.getProperties().getProperty("get_brands");
                    HttpClient client = HttpClientBuilder.create().build();

                    HttpGet get = new HttpGet(api_url);

                    get.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

                    HttpResponse response = client.execute(get);
                    String result = EntityUtils.toString(response.getEntity());
                    Gson gson = new Gson();
                    BrandList brandList = gson.fromJson(result, BrandList.class);
                    if (!brandList.isError()) {
                        List<Brand> br = brandList.getMessage();
                        for (Brand br1 : br) {
                            brandModal.getBrandId().add(br1.getValue());
                            brandModal.getBrandName().add(br1.getLabel());
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.run();
       }
        return brandModal;
    }

}
