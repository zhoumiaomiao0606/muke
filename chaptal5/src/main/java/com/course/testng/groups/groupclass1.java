package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "student")
public class groupclass1 {

    public  void  stu1(){
        System.out.println("我是groupclass1学生111111");
    }
    public  void  stu2(){
        System.out.println("我是学生groupclass122222");
    }
    public  void  stu3(){
        System.out.println("我是学生groupclass1333333");
    }
}
