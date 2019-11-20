package com.lue.jeptags.util;

import com.google.gson.Gson;
import com.lue.jeptags.entity.EncodeScan1;
import com.lue.jeptags.entity.EncodeScan2;
import com.lue.jeptags.entity.EncodeScanMessage1;
import com.lue.jeptags.entity.EncodeScanMessage2;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lue
 */
public class CheckTags {

    private final String USER_AGENT = "Mozilla/5.0";

    public List sendPost(String sUid) throws Exception {
        List<String> message = new ArrayList<>();
        new Runnable() {
            @Override
            public void run() {

               
                try {
                    String api_url = UrlProperties.getProperties().getProperty("encode_scan");
                    URL obj = new URL(api_url);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    con.setConnectTimeout(90000);
                    con.setReadTimeout(90000);
                    con.setRequestMethod("POST");
                    con.setRequestProperty("Content-Type", "application/json");
                    String urlParameters = "{\"tag_id\":\"" + sUid + "\"}";

                    // Send post request
                    con.setDoOutput(true);
                    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                    wr.writeBytes(urlParameters);
                    wr.flush();
                    wr.close();

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
//                    System.out.println(response.toString());
                    if (response.toString().contains("\"error\":false")) {
                        if (response.toString().contains("\"type\":\"2\"")) {
                            Gson gson = new Gson();
                            EncodeScan2 ecs = gson.fromJson(response.toString(), EncodeScan2.class);
                            EncodeScanMessage2 ecsm = ecs.getMessage();
                            message.add("2");
                            message.add(ecsm.getJeptag_id());
                            message.add(ecsm.getMessage());
                            message.add(ecsm.getAlert());
                        } else if (response.toString().contains("\"type\":\"1\"")) {
                            Gson gson = new Gson();
                            EncodeScan1 ecs = gson.fromJson(response.toString(), EncodeScan1.class);
                            EncodeScanMessage1 ecsm = ecs.getMessage();
                            message.add("1");
                            message.add(ecsm.getProduct_id());
                            message.add(ecsm.getName());
                            message.add(ecsm.getProduct_url());
                        }
                    } else {
                        message.add("0");
                    }
                } catch (IOException ex) {
                    System.out.println("IOException- " + ex.toString());
                }
            }
        }.run();
        return message;

    }
}
