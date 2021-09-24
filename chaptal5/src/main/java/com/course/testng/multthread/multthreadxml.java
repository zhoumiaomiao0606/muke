package com.course.testng.multthread;

import org.testng.annotations.Test;

public class multthreadxml {


    @Test
    public void testxml(){
        System.out.println("测试test");
        System.out.printf("threadid: " +Thread.currentThread().getId());
    }
    @Test
    public void testxml1(){
        System.out.println("测试test1");
        System.out.printf("threadid: " +Thread.currentThread().getId());
    }
}
