package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupmothodtest {
    @Test(groups = "servers")
    public void groupserver(){
        System.out.println("这是服务端分组11111");
    }
    @Test(groups = "servers")
    public void groupserver2(){
        System.out.println("这是服务端分组222222");
    }

   @Test(groups = "client")
    public void groupclient(){
        System.out.println("这客户端分组11111");
    }
    @Test(groups = "client")
    public void groupclient1(){
        System.out.println("这是客户端分组222222");
    }

@BeforeGroups("servers")
    public void group(){
        System.out.println("这是服务端运行前");
    }
@AfterGroups("servers")
    public void group1(){
        System.out.println("这是服务端运行后");
    }

    @BeforeGroups("client")
    public void group2(){
        System.out.println("这是客户端运行前");
    }
    @AfterGroups("client")
    public void group3(){
        System.out.println("这是客户端运行后");
    }
}
