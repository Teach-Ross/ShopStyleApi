package com.test.controller;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;



@Controller
public class HomeController {

    @RequestMapping("/")

    public String jeansImages(Model model)
    {
        //used to generate random offset for search query and to generate random product index
        Random random = new Random();

        try {
            //provides access to by sending requests through http protocol to other http servers
            HttpClient http = HttpClientBuilder.create().build();

            //address to call, port 80 is a default
            //port number 443 for https connection (usually)
            HttpHost host = new HttpHost("api.shopstyle.com", 80, "http");

            //reference to location we are trying to retrieve data from
            int offset = random.nextInt(500);
            HttpGet getPage = new HttpGet("/api/v2/products?pid=uid5921-39054839-10&fts=jeans&limit=25&offset=" + offset);

            //execute HTTP request and get HTTP response back
            HttpResponse resp = http.execute(host, getPage);

            // Put the JSON to a string object
            String jsonString = EntityUtils.toString(resp.getEntity());
            JSONObject obj = new JSONObject(jsonString);


            JSONArray ar = obj.getJSONArray("products");


            //identify random product
            JSONObject productObject = ar.getJSONObject(random.nextInt(25));
            String image1 = productObject.getJSONObject("image").getJSONObject("sizes").getJSONObject("XLarge").getString("url");
            int id1 = productObject.getInt("id");

            model.addAttribute("image1", image1);
            model.addAttribute("id1", id1);

            JSONObject productObject2 = ar.getJSONObject(random.nextInt(25));
            String image2 = productObject2.getJSONObject("image").getJSONObject("sizes").getJSONObject("XLarge").getString("url");
            int id2 = productObject2.getInt("id");

            model.addAttribute("image2", image2);
            model.addAttribute("id2", id2);

            JSONObject productObject3 = ar.getJSONObject(random.nextInt(25));
            String image3 = productObject3.getJSONObject("image").getJSONObject("sizes").getJSONObject("XLarge").getString("url");
            int id3 = productObject3.getInt("id");

            model.addAttribute("image3", image3);
            model.addAttribute("id3", id3);



            return "welcome";

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


        return "welcome";
    }


    @RequestMapping("result")

    public String getResult(Model model, @RequestParam("id") String productId) {
        try {
            //provides access to by sending requests through http protocol to other http servers
            HttpClient http = HttpClientBuilder.create().build();

            //address to call, port 80 is a default
            //port number 443 for https connection (usually)
            HttpHost host = new HttpHost("api.shopstyle.com", 80, "http");

            //reference to location we are trying to retrieve data from
            String productUrl = "http://api.shopstyle.com/api/v2/products/" + productId + "?pid=uid5921-39054839-10";
            HttpGet getPage = new HttpGet(productUrl);

            //execute HTTP request and get HTTP response back
            HttpResponse resp = http.execute(host, getPage);

            // Put the JSON to a string object
            String jsonString = EntityUtils.toString(resp.getEntity());
            JSONObject obj = new JSONObject(jsonString);



            //gather product name and description
            model.addAttribute("name", obj.getString("brandedName"));
            model.addAttribute("description", obj.getString("description"));

            //gather product category
            JSONArray categoryArray = obj.getJSONArray("categories");

            for (int i = 0; i < categoryArray.length(); i++) {
                JSONObject tag = categoryArray.getJSONObject(i);
                String name = "categoryName" + i;
                model.addAttribute(name, tag.getString("name"));
            }

            JSONArray colorArray = obj.getJSONArray("colors");
            JSONObject color = obj.getJSONArray("colors").getJSONObject(0);
            model.addAttribute("color", color.getString("name"));
            
            for(int i = 0; i < colorArray.length(); i++){
                JSONObject color2 = colorArray.getJSONObject(i);
                JSONArray ar = color2.getJSONArray("canonicalColors");
                for(int j = 0; j < ar.length(); j++){
                    String colorName = "colorName" + j;
                    model.addAttribute(colorName, ar.getJSONObject(j).getString("name"));
                }

            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return "result";
    }
}
