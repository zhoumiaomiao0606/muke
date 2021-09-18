package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class groupteacher {



    public  void  stu1(){
        System.out.println("我是groupteacher老师111111");
    }
    public  void  stu2(){
        System.out.println("我是groupteacher老师122222");
    }
    public  void  stu3(){
        System.out.println("我是groupteacher老师33333");
    }
}
