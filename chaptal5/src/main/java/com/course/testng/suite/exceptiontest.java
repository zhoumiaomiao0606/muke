package com.course.testng.suite;

import org.testng.annotations.Test;

public class exceptiontest {

    @Test(expectedExceptions =RuntimeException.class)
    public void runerror() {

        System.out.println("测试失败，");
    }


    @Test(expectedExceptions =RuntimeException.class)
    public void runerror1() {
        System.out.println("测试失败");
    throw new RuntimeException() ;

    }
}
