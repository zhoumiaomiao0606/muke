package com.course.testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class dateprovidertest {

    @Test(dataProvider ="test")
    public void test1(String name, int age){
    System.out.println("name="+name+"; age="+age);

    }
    @Test(dataProvider = "test")
    public void test2(String name,int age){
        System.out.println("name="+name+"; age="+age);

    }

   // @DataProvider(name="test")
       public Object[][]  providerdate(){
    Object[][] O =new Object[][]{
            {"zhouzhou",18},
            {"zhangsan",20}
    };
    return O;


}
@DataProvider(name="test")
   public  Object[][] method(Method method){
        Object[][]  o=null;
        if (method.getName().equals("test1")){
            o =new Object[][]{
                    {"zhouzhou",18},
                    {"zhangsan",20}
            };
        }else if (method.getName().equals("test2")){
            o =new Object[][]{
                    {"dada",29},
                    {"mama",30}
            };
        }

        return o;


   }


}
