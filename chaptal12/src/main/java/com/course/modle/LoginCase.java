package com.course.modle;

import lombok.Data;

@Data
public class LoginCase {
    private  int id;
    private  String userName;
    private  String expected;
    private  String password;
    public String toString(){
        return ("{id;"+id+","+

                "expected;"+expected+","+
                "password;"+password+","+

                "userName;"+userName+"}"

        );
    }
}
