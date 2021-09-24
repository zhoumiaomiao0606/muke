package com.course.cases;

import com.course.config.TestConfig;
import com.course.modle.AddUserCase;
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

public class AddUserTest {
    @Test(dependsOnGroups = "LoginTrue",description = "测试添加人员成功")
    public  void AddUserTest() throws IOException {
        SqlSession sqlSession= DatanaseUtil.getSqlsession();
        AddUserCase addUserCase=sqlSession.selectOne("AddUserCase",1);
        System.out.println(TestConfig.addUserUrl);
        System.out.println(addUserCase.toString());

        //发请求获取结果
        String result=getrsult(addUserCase);
        //验证返回结果
        User user=sqlSession.selectOne("adduser",addUserCase);
        //是否相等
        System.out.println(user.toString());
        Assert.assertEquals(addUserCase.getExpected(),result);
    }

    private String getrsult(AddUserCase addUserCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param=new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("age",addUserCase.getAge());
        param.put("sex",addUserCase.getSex());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());
        //设置信息头
        post.setHeader("content-type","application/json");
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //设置cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        HttpResponse response=TestConfig.defaultHttpClient.execute(post);
        String result= EntityUtils.toString(response.getEntity());
        System.out.println(result);
        return  result;
    }
}
