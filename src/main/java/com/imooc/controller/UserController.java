package com.imooc.controller;

import com.imooc.pojo.IMoocJSONResult;
import com.imooc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setName("imooc2");
        user.setAge(19);
        user.setBirthday(new Date());
        user.setPassword("imooc2");
        user.setDesc("hello imooc..");

        return user;
    }

    @RequestMapping("/getUserJson")
    public IMoocJSONResult getUserJson(){
        User user = new User();
        user.setName("imooc");
        user.setBirthday(new Date());
        user.setPassword("imooc2");
        user.setDesc("hello imooc ---");
        return IMoocJSONResult.ok(user);
    }

}
