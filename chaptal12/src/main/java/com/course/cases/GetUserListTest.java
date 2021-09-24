package com.course.cases;

import com.course.config.TestConfig;
import com.course.modle.GetUserListCase;
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
import java.util.List;


public class GetUserListTest {
    @Test(dependsOnGroups = "LoginTrue",description = "查询用户列表")
    public  void GetUserListTest() throws IOException {
        SqlSession sqlSession= DatanaseUtil.getSqlsession();
        GetUserListCase getUserListCase=sqlSession.selectOne("GetUserListCase",1);
        System.out.println(TestConfig.getUserListUrl);
        System.out.println(getUserListCase.toString());
        //发送请求获取结果
        JSONArray resultjson=getJsonResult(getUserListCase);
        //数据库查询结果
        List<User> userList=sqlSession.selectList("getuserlist",getUserListCase);
        //验证
    for(User u:userList){
        System.out.println("获取的结果是："+u.toString());
        JSONArray userlistJsonarray= new JSONArray(userList);
        Assert.assertEquals(userlistJsonarray.length(),resultjson.length());
        for(int i = 0; i <resultjson.length(); i++){
            JSONObject expect=(JSONObject) resultjson.get(i);
            JSONObject actul=(JSONObject) userlistJsonarray.get(i);
            Assert.assertEquals(expect.toString(),actul.toString());
        }
    }
    }

    private JSONArray getJsonResult(GetUserListCase getUserListCase) throws IOException {
        HttpPost post =new HttpPost(TestConfig.getUserListUrl);
        JSONObject param=new JSONObject();
        param.put("userName",getUserListCase.getUserName());
        param.put("sex",getUserListCase.getSex());
        param.put("age",getUserListCase.getAge());
        post.setHeader("content-type","application/json");
        StringEntity entity= new StringEntity(param.toString(),"utf-8");
         post.setEntity(entity);
         TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        HttpResponse response= TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        JSONArray jsonArray=new JSONArray(result);
        return  jsonArray;
    }
}
