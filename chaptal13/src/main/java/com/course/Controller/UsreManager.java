package com.course.Controller;

import com.course.modle.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Log4j
@RestController
@Api(value = "/",description = "这是用户接口")
public class UsreManager {
@Autowired
    private SqlSessionTemplate template;
@RequestMapping(value = "login" ,method = RequestMethod.POST)
    @ApiOperation(value = "登录接口",httpMethod = "POST")
    public Boolean Login(HttpServletResponse response, @RequestBody User use ){

   int num=template.selectOne("login",use);
   log.info("num"+num);
    Cookie cookie =new Cookie("login","true");
    response.addCookie(cookie);
    log.info("查询到的结果是"+num);
    if(num==1){
        log.info("登录用户是"+use.getUserName());
        return true ;
    }
    return false;

}
@ApiOperation(value = "添加用户接口",httpMethod = "POST")
    @RequestMapping(value = "adduser",method = RequestMethod.POST)
    public Boolean Adduser(HttpServletRequest request,@RequestBody User user){
     Boolean x=verifycookies(request);
int num=0;
if(x!=null){
    num=template.insert("Adduser",user);
    return true;
}
if(num>0){
log.info("插入的数量是"+num);
}
return  false;
}
@ApiOperation(value = "查询接口",httpMethod = "POST")
@RequestMapping(value = "getuserinfo",method = RequestMethod.POST)
public List<User> getUserInfo(HttpServletRequest request,@RequestBody User user){
    boolean i=verifycookies(request);


    if(i==true){
        List<User>    userList=template.selectList("GetUserInfo",user);
        log.info("获取到的用户数量是" + userList.size());
        return userList;
    }
    else{
        return  null;
    }
}
    @ApiOperation(value = "更新接口",httpMethod = "POST")
    @RequestMapping(value = "updateuserinfo",method = RequestMethod.POST)
    public  int updateUserInfo(HttpServletRequest request,@RequestBody User user){
    Boolean i=verifycookies(request);
        log.info("i值是"+i);
    int num =0;
    if(i==true){
        num=template.update("UpdateUserInfo",user);
    }
    log.info("获取用户量是"+num);
    return  num;
    }

private  Boolean verifycookies(HttpServletRequest request){
    Cookie[] cookies =request.getCookies();
    log.info(cookies);
    if(Objects.isNull(cookies)){
    log.info("cooies结果为空");
    return  false;

    }
    for(Cookie cookie:cookies){
        if(cookie.getName().equals("login") &&cookie.getValue().equals("true")){
            log.info("验证通过");
            return true;
        }
    }
    return  false;
}


}
