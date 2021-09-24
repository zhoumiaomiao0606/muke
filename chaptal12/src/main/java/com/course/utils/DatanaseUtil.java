package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatanaseUtil {
    public  static SqlSession getSqlsession() throws IOException {
        //获取配置文件资源
        Reader reader= Resources.getResourceAsReader("databaseconfig.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        //执行sql
        SqlSession sqlSession=sessionFactory.openSession();
        return  sqlSession;
    }
}
