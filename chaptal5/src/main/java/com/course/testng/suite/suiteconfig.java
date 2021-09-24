package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class suiteconfig {
    @BeforeSuite
    public void beforeSuite(){

        System.out.println("beforeSuite套件运行前");
    }
    @AfterSuite
    public void afterSuite(){

        System.out.println("afterSuite套件运行后");
    }

    @BeforeTest
    public void BeforeClass(){
        System.out.println("BeforeClass测试类前");
    }
    //注意afterclass不行，suite.xml执行顺序按照配置来，会把suiteconfig的所有东西给执行出来，
    @AfterTest
    public void AfterClass(){
        System.out.println("BeforeClass测试类前");

    }
}
