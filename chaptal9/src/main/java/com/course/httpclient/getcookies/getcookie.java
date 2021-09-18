package com.course.httpclient.getcookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class getcookies {


    private String url;
    private ResourceBundle bundle;

    @BeforeTest
    public  void befortest(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }


    @Test
    public void getcookie() throws IOException {
    String uri=bundle.getString("getcookies.url");
    String  testurl=this.url+uri;

        System.out.println(testurl);
        String result;
        HttpGet get =new HttpGet("testurl");
        HttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result= EntityUtils.toString(response.getEntity());
        System.out.println(result);


    }




}
