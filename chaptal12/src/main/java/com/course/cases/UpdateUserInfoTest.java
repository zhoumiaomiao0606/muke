package com.course.cases;

import com.course.config.TestConfig;
import com.course.modle.UpdateUserInfoCase;
import com.course.modle.User;
import com.course.utils.DatanaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserInfoTest {
    @Test(dependsOnGroups = "LoginTrue",description = "更新客户信息")
    public void UpdateUserInfo() throws IOException {
        SqlSession sqlSession= DatanaseUtil.getSqlsession();
        UpdateUserInfoCase updateUserInfoCase=sqlSession.selectOne("UpdateUserInfoCase",1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
        //执行结果
        int result= gentlest(updateUserInfoCase);
        //查询数据库结果
        User user =sqlSession.selectOne("updateuserinfo",updateUserInfoCase);
        Assert.assertNotNull(result);
        Assert.assertNotNull(user);
    }

    private int gentlest(UpdateUserInfoCase updateUserInfoCase) throws IOException {
        HttpPost post=new HttpPost(TestConfig.updateUserInfoUrl);
        JSONObject pram=new JSONObject();
        pram.put("id",updateUserInfoCase.getUserld());
        pram.put("userName",updateUserInfoCase.getUserName());
        pram.put("password",updateUserInfoCase.getPassword());
        pram.put("sex",updateUserInfoCase.getSex());
        pram.put("age",updateUserInfoCase.getAge());
        pram.put("permission",updateUserInfoCase.getPermission());
        pram.put("isDelete",updateUserInfoCase.getIsDelete());
        post.setHeader("content-type","application/json");
        StringEntity entity=new StringEntity(pram.toString(),"utf-8");
        post.setEntity(entity);

        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        HttpResponse response= TestConfig.defaultHttpClient.execute(post);

        String result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        return Integer.parseInt(result);}

    @Test(dependsOnGroups = "LoginTrue",description = "删除客户信息")
    public void DeleteUserInfo() throws IOException {
        SqlSession sqlSession= DatanaseUtil.getSqlsession();
        UpdateUserInfoCase updateUserInfoCase=sqlSession.selectOne("DeleteUserInfoCase",2);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
        //执行结果
        int result= gentlest(updateUserInfoCase);
        //查询数据库结果
        User user =sqlSession.selectOne("updateuserinfo",updateUserInfoCase);
        Assert.assertNotNull(result);
        Assert.assertNotNull(user);
    }

}
