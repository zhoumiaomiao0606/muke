package com.course.modle;

import lombok.Data;

@Data
public class GetUserListCase {
    private  int id;
    private  int age;
    private  int sex;
    private  String userName;
    private  String expected;
    public String toString(){
        return ("{id;"+id+","+
                "age;"+age+","+
                "sex;"+sex+","+
                "expected;"+expected+","+
                "userName;"+userName+"}"

        );
    }
}
