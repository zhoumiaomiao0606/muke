package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@Api(value = "/",description= "这是我的get方法")
@RestController
public class Mygetmethod {
    @RequestMapping(value = "/getcookies",method = RequestMethod.GET)
    @ApiOperation(value = "添加cookie",httpMethod ="GET" )
public String getcookies(HttpServletResponse  response ){

       // HttpServletResponse;存放响应结果
      //  HttpServletRequest;存放请求结果
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookie成功";
}

@ApiOperation(value = "携带cookies方法",httpMethod ="GET")
@RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getwithcookies(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(Objects.isNull(cookies)){
      return "必须携带cookies";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "恭喜你获得cookies成功";
            }
        }
        return "必须携带cookies访问";
}
//get带请求参数的2种方法

    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "get请求的第一种方法",httpMethod = "GET")
    public Map<String, Integer> withparam(@RequestParam int start,@RequestParam int end){
        Map<String, Integer> map=new HashMap<>();
        map.put("鞋子",100);
        map.put("米",2);
        map.put("面",3);
       return map;

    }
    //第二种get参数的方法
    @ApiOperation(value = "get请求的第二种方法",httpMethod = "GET")
    @RequestMapping(value ="/with/param/{start}/{end}")
public Map withparam(@PathVariable Integer start,@PathVariable  Integer end){
Map<String,Integer> map= new HashMap<>();
    map.put("鞋子",100);
    map.put("米",2);
    map.put("面",3);
    return  map;
}
}
