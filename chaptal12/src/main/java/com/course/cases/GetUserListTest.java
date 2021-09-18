package com.course.cases;

import com.course.config.TestConfig;
import com.course.modle.GetUserListCase;
import com.course.utils.DatanaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserListTest {
    @Test(dependsOnGroups = "LoginTrue",description = "测试添加人员成功")
    public  void GetUserListTest() throws IOException {
        SqlSession sqlSession= DatanaseUtil.getSqlsession();
        GetUserListCase getUserListCase=sqlSession.selectOne("GetUserList",1);
        System.out.println(TestConfig.getUserListUrl);
        System.out.println(getUserListCase.toString());
    }
}
