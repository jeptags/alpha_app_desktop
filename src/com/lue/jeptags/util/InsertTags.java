package com.lue.jeptags.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class InsertTags {

    private String lastJepTag = "";
    boolean flag = false;

   
    public boolean InsertAllTag(ImportTagListModal itlm) {

        new Runnable() {
            @Override
            public void run() {
                try {
                    String api_url = "http://54.67.107.248/jeptags/apirest/encoding/encode_create_new";
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpPost post = new HttpPost(api_url);

                    post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
                    Gson gson = new Gson();
                    String stringJson = gson.toJson(itlm);
                    StringEntity entity = new StringEntity(stringJson);
                    post.setEntity(entity);
                    HttpResponse response = client.execute(post);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    StringBuffer result = new StringBuffer();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    System.out.println("Result-- " + result);

                    Response res = gson.fromJson(result.toString(), Response.class);

                    if (!res.isError()) {
                        //row.add(rowNo);
                        flag = true;
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Encode Error" + ex.toString());
                }

            }
        }.run();
        return flag;
    }

    public String getLastJepTag() {

        new Runnable() {
            @Override
            public void run() {
                try {
                    String api_url = "http://54.67.107.248/jeptags/apirest/encoding/encode_last";
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpGet get = new HttpGet(api_url);
                    get.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

                    HttpResponse response = client.execute(get);
                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    StringBuffer result = new StringBuffer();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    Gson gson = new Gson();
                    EncodeLastResponse encodeLastResponse = gson.fromJson(result.toString(), EncodeLastResponse.class);

                    if (!encodeLastResponse.isError()) {
                        EncodeLast mess = encodeLastResponse.getMessage().get(0);
                        lastJepTag = mess.getJeptag_id();
                    }
                } catch (JsonSyntaxException | IOException | UnsupportedOperationException ex) {
                    System.out.println("Exception during fetching last tag:--- " + ex.toString());
                }
            }
        }.run();

        return lastJepTag;
    }
}
