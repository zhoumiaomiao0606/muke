package com.course.cases;

import com.course.config.TestConfig;
import com.course.modle.InterfaceName;
import com.course.modle.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatanaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {
    @BeforeTest(groups = "login",description = "测试前的准备")
    public void befortest(){
        TestConfig.addUserUrl= ConfigFile.getUrl(InterfaceName.ADDUSER);
        TestConfig.getUserInfoUrl=ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl= ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.updateUserInfoUrl=ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.loginUrl=ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.defaultHttpClient=new DefaultHttpClient();
    }
    @Test(groups = "LoginTrue",description = "登录成功")
    public  void LoginTrue() throws IOException {
        SqlSession sqlSession= DatanaseUtil.getSqlsession();
        LoginCase loginCase=sqlSession.selectOne("LoginTrueCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
        String  result=getresult(loginCase);

        Assert.assertEquals(loginCase.getExpected(),result);

    }

    private String getresult(LoginCase loginCase) throws IOException {


        HttpPost post =new HttpPost(TestConfig.loginUrl);
        JSONObject param=new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());
        post.setHeader("content-type","application/json");
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        HttpResponse response=TestConfig.defaultHttpClient.execute(post);
        String result= EntityUtils.toString(response.getEntity());
        System.out.println(result);
        TestConfig.cookieStore=TestConfig.defaultHttpClient.getCookieStore();
        System.out.println("cookie"+TestConfig.cookieStore);
        return  result;
    }

    @Test(groups = "Loginfalse",description = "登录失败")
    public  void LoginFalse() throws IOException {
        SqlSession sqlSession= DatanaseUtil.getSqlsession();
        LoginCase loginCase=sqlSession.selectOne("LoginTrueCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);



        String  result=getresult(loginCase);

        Assert.assertEquals(loginCase.getExpected(),result);
    }
}
