package com.course.httpclient.getcookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class postcookies {
    private ResourceBundle bundle;
    private String url;
    private CookieStore cookieStore;

    @BeforeTest
    public void befortest(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }

    @Test
    public void postcookiesget() throws IOException {
        String testurl=this.url+bundle.getString("getcookies.url");
        DefaultHttpClient client=new DefaultHttpClient();
        HttpGet httpGet=new HttpGet(testurl);
        HttpResponse response=client.execute(httpGet);
    cookieStore=client.getCookieStore();
        List<Cookie> cookies=cookieStore.getCookies();
        for(Cookie cookie:cookies){
            String key=cookie.getName();
            String value=cookie.getValue();
            System.out.println("key="+key+";value="+value);
        }
    }
    @Test(dependsOnMethods ="postcookiesget" )
public  void postcookieparam() throws IOException {
        //获取url
    String testurl=this.url+bundle.getString("test.post.withparam.cookies");
        //创建执行端
    DefaultHttpClient httpClient=new DefaultHttpClient();
    //创建请求
    HttpPost httpPost=new HttpPost(testurl);
    //添加参数，首先需要json格式
    JSONObject  json =new JSONObject();
    json.put("name","zhouzhou");
    json.put("age","18");
    //信息头存储
    httpPost.setHeader("content-type","application/json");
    //cookies,存储
    httpClient.setCookieStore(cookieStore);
    //把参数给关联起来
    StringEntity entity=new StringEntity(json.toString(),"utf-8");
    httpPost.setEntity(entity);
    //执行
    HttpResponse response=  httpClient.execute(httpPost);
    String result=EntityUtils.toString(response.getEntity());
        System.out.println(result);
    //string转换为json
    JSONObject jsonObject=new JSONObject(result);
    //判断结果
        String name= (String) jsonObject.get("name");
        String age= (String) jsonObject.get("status");
        Assert.assertEquals("zhouzhou",name);
        Assert.assertEquals("1",age);
}

}
