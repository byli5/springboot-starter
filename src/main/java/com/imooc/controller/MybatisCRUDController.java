package com.imooc.controller;

import com.imooc.pojo.IMoocJSONResult;
import com.imooc.pojo.SysUser;
import com.imooc.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisCRUDController {

    @Autowired
    private UserService userService;


    @RequestMapping("/saveUser")
    public IMoocJSONResult saveUser()throws Exception{
//        String userId = UUID.randomUUID().toString().substring(0,20);
        String userId = Sid.nextShort();
        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("imooc"+new Date());
        user.setNickname("imooc"+new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.saveUser(user);
        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public IMoocJSONResult updateUser(){
        SysUser user = new SysUser();
        user.setId("10011001");
        user.setUsername("10011001-updated" + new Date());
        user.setNickname("10011001-updated" + new Date());
        user.setPassword("10011001-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);

        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/queryUserListPaged")
    public IMoocJSONResult queryUserListPaged(Integer page){
        if (page == null){
            page = 1;
        }
        SysUser user = new SysUser();
        int pageSize = 10;
        List<SysUser> userList = userService.queryUserListPaged(user,page,pageSize);

        return IMoocJSONResult.ok(userList);
    }
}
