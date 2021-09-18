package com.course.testng.suite;

import org.testng.annotations.Test;

public class depnedtest {

    @Test
    public void tset1(){
        System.out.println("测试1运行");
        throw  new RuntimeException();
    }
    @Test(dependsOnMethods = "tset1")
    public void tset2(){
        System.out.println("测试2运行");
    }
}
