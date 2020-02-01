package com.imooc.controller;

import com.imooc.pojo.IMoocJSONResult;
import com.imooc.pojo.SysUser;
import com.imooc.pojo.User;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test")
    public IMoocJSONResult test(){
        redisTemplate.opsForValue().set("imooc-cache","hello imooc");

        SysUser sysUser = new SysUser();
        sysUser.setId("10011");
        sysUser.setUsername("imooc");
        sysUser.setPassword("1213");
        sysUser.setIsDelete(0);
        sysUser.setRegistTime(new Date());
        redisTemplate.opsForValue().set("json:user", JsonUtils.objectToJson(sysUser));

        SysUser jsonUser;
        jsonUser = JsonUtils.jsonToPojo(redisTemplate.opsForValue().get("json:user"),SysUser.class);

        return IMoocJSONResult.ok(jsonUser);
    }

    @RequestMapping("/getJsonList")
    public IMoocJSONResult  getJsonList(){
        User user = new User();
        user.setAge(18);
        user.setName("慕课网");
        user.setPassword("123456");
        user.setBirthday(new Date());

        User u1 = new User();
        u1.setAge(19);
        u1.setName("imooc");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("hello imooc");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);

        redis.set("json:info:uerList",JsonUtils.objectToJson(userList),2000);

        List<User> userListJson = JsonUtils.jsonToList(redis.get("json:info:uerList"),User.class);
        return IMoocJSONResult.ok(userListJson);
    }

}
