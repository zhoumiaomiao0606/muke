package com.course.cases;

import com.course.config.TestConfig;
import com.course.modle.GetUserInfoCase;
import com.course.modle.User;
import com.course.utils.DatanaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetUserInfoTest {
    @Test(dependsOnGroups = "LoginTrue",description = "查询客户信息")
    public void GetUserInfo() throws IOException {
        SqlSession sqlSession= DatanaseUtil.getSqlsession();
        GetUserInfoCase getUserInfoCase=sqlSession.selectOne("GetUserInfoCase",1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);

        //获取执行结果
        JSONArray jsonresult=getJsonresult(getUserInfoCase);
        //获取数据库查询结果
        User user =sqlSession.selectOne("getuserinfo",getUserInfoCase);
        List userlist=new ArrayList();
        userlist.add(user);
        JSONArray jsonArray=new JSONArray(userlist);
        JSONArray jsonArray1=new JSONArray(jsonresult.getString(0));
        Assert.assertEquals(jsonArray1.toString(),jsonArray.toString());

    }

    private JSONArray getJsonresult(GetUserInfoCase getUserInfoCase) throws IOException {
        HttpPost post=new HttpPost(TestConfig.getUserInfoUrl);
        JSONObject param=new JSONObject();
        param.put("id",getUserInfoCase.getUserld());
        post.setHeader("content-type","application/json");
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        HttpResponse response=TestConfig.defaultHttpClient.execute(post);
        String result= EntityUtils.toString(response.getEntity(),"utf-8");
        List resultlist= Arrays.asList(result);
        JSONArray jsonArray=new JSONArray(resultlist);
        System.out.println(jsonArray);
        return jsonArray;
    }
}
