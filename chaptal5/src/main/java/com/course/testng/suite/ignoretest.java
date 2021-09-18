package com.course.testng.suite;

import org.testng.annotations.Test;

public class ignoretest {


    @Test
    public  void ignore1(){
        System.out.println("ignor1测试");
    }
    @Test(enabled = false)
    public  void ignore2(){
        System.out.println("ignor2测试");
    }
    @Test
    public  void ignore3(){
        System.out.println("ignor3测试");
    }
}
