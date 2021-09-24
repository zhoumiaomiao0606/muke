package com.course.modle;

import lombok.Data;

@Data
public class GetUserInfoCase {
    private  int id;
    private  int userld;
    private String expected;
    public String toString(){
        return ("{id;"+id+","+
                "userid;"+userld+","+

                "expected;"+expected+"}"

        );
    }
}
