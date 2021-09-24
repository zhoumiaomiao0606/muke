package com.course.httpclient.getcookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class getcookie {


    private String url;
    private ResourceBundle bundle;
    private  CookieStore cookieStore;
    @BeforeTest
    public  void befortest(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }


    @Test
    public void getcookie() throws IOException {
    String uri=bundle.getString("getcookies.url");
    //拼接url
    String  testurl=this.url+uri;


        String result;
        HttpGet httpGet =new HttpGet(testurl);
//获取cookies  HttpClient DefaultHttpClient
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(httpGet);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies
         cookieStore=client.getCookieStore();
        List<Cookie> cookies =cookieStore.getCookies();
        for(Cookie cookie:cookies){

            String key=cookie.getName();
            String value=cookie.getValue();
            System.out.println("key="+key+";   value="+value);

        }


    }
@Test(dependsOnMethods = "getcookie")
public  void setcookies() throws IOException {
        //获取接口连接

   String testurl=this.url+bundle.getString("test.get.withcookies");
    HttpGet get =new HttpGet(testurl);
    DefaultHttpClient httpClient=new DefaultHttpClient();
    //获取cookies
    httpClient.setCookieStore(this.cookieStore);
    HttpResponse result=httpClient.execute(get);
    int statucode=result.getStatusLine().getStatusCode();
    if(statucode==200){
        System.out.println(EntityUtils.toString(result.getEntity()));
    }

}

}
