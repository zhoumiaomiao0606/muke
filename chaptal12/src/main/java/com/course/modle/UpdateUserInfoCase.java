package com.course.modle;

import lombok.Data;

@Data
public class UpdateUserInfoCase {
    private  int id;
    private  int age;
    private  String userName;
    private  int sex;
    private  int permission;
    private  int isDelete;
    private  String password;
    private  int userld;
    private  String expected;
    public String toString(){
        return ("{id;"+id+","+
                "age;"+age+","+
                "sex;"+sex+","+
                "permission;"+permission+","+
                "userName;"+userName+","+
                "password;"+password+","+
                "isDelete;"+isDelete+","+
                "expected;"+expected+","+
                "userld;"+userld+"}"

        );
    }
}
