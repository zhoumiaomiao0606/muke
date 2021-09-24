package com.course.testng.multthread;

import org.testng.annotations.Test;

public class multthreadtest {


@Test(invocationCount = 10,threadPoolSize = 3)
    public void multtest(){
        System.out.println("1");
    System.out.printf("threadid: " +Thread.currentThread().getId());
    }
}
