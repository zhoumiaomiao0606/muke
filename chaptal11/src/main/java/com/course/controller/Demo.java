package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(value = "/",description = "这是我的第一个查询sql")
@Log4j
public class Demo {
    //首先获取一个执行sql语句的对象
    @Resource
    private SqlSessionTemplate template;

    @RequestMapping(value="getUserCount",method= RequestMethod.GET)
    @ApiOperation(value="get user count",httpMethod ="GET" )
    public int getUserCount(){
        return template.selectOne("getUserCount");

    }
    @RequestMapping(value = "adduser",method =RequestMethod.POST)
    public int adduser(@RequestBody User user){
        return  template.insert("adduser",user);
    }
    @RequestMapping(value = "updateuser",method = RequestMethod.POST)
    public  int updateuser(@RequestBody User user){
        return template.update("updateuser",user);
    }
    @RequestMapping(value = "deletuser",method = RequestMethod.GET)
    public int deletuser(@RequestParam int id){
        return  template.delete("deletuser",id);
    }
}
