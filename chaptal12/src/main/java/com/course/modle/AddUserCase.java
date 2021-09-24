package com.course.modle;

import lombok.Data;

@Data
public class AddUserCase {
    private  int id;
    private  int age;
    private  int sex;
    private  int permission;
    private  int isDelete;
    private  String password;
    private  String userName;
    private  String expected;
    public String toString(){
        return ("{id;"+id+","+
                "age;"+age+","+
                "sex;"+sex+","+
                "permission;"+permission+","+
                "password;"+password+","+
                "isDelete;"+isDelete+","+
                "expected;"+expected+","+
                "userName;"+userName+"}"

        );
}}
