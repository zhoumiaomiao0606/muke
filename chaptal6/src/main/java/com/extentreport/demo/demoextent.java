package com.extentreport.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class demoextent {
    @Test
    public  void test1(){
        Assert.assertEquals(1,2);

    }
    @Test
    public  void test2(){
        Assert.assertEquals(1,1);

    }
    @Test
    public  void test3(){
        Assert.assertEquals("qqq","qqq");

    }
    @Test
    public  void no(){
        System.out.println("这会出问题");
        throw new RuntimeException("这是我自己额异常");

    }
}
