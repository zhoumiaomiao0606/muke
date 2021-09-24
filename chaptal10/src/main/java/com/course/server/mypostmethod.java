package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value ="/",description = "这是我的post请求")
public class mypostmethod {

    @RequestMapping(value = "/post/login",method = RequestMethod.POST)
    @ApiOperation(value = "post登录",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam (value = "name",required = true)String name, @RequestParam(value = "phone",required = true) String phone){
        if(name.equals("zhouzhou")&&phone.equals("18667941802")){
            Cookie cookie=new Cookie("login","true");
            response.addCookie(cookie);

            return "恭喜你登录成功";
        }
return "登录失败";
    }

    @RequestMapping(value = "/post/getuser",method =RequestMethod.POST)
    @ApiOperation(value = "获取user列表",httpMethod = "POST")
    public String getuserlist(HttpServletRequest request, @RequestBody User u){
        User user;
        Cookie[] c=request.getCookies();
        for(Cookie cookie:c){

            if(cookie.getName().equals("login") &&
                    cookie.getValue().equals("true") &&
                    u.getName().equals("zhouzhou") && u.getPhone().equals("18667941802")){
                user =new User();
                user.setAge("18");
                 user.setSex("女");
        return  user.toString();
            }

        }
return "参数不合规定";
    }

}
