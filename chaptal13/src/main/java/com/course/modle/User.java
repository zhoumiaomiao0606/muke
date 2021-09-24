package com.course.modle;

import lombok.Data;

@Data
public class User {
    private  int id;
    private  int age;
    private  int sex;
    private  int permission;
    private  int isDelete;
    private  String userName;
    private  String password;
    public String toString(){
        return ("{id;"+id+","+
                "age;"+age+","+
                "sex;"+sex+","+
                "permission;"+permission+","+
                "password;"+password+","+
                "isDelete;"+isDelete+","+
                "userName;"+userName+"}"

        );
    }
}
