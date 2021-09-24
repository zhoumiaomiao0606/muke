package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class httpcientdemo {
    @Test
    public void tetdemo() throws IOException {
        String reslut;
        HttpGet get = new HttpGet("http://system.yunchejinrong.com/order");
        HttpClient httpClient = new DefaultHttpClient();

        HttpResponse httpResponse = httpClient.execute(get);

        reslut = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(reslut);
    }



}
