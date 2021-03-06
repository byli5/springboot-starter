package com.imooc.controller;

import com.imooc.pojo.IMoocJSONResult;
import com.imooc.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping("/test")
    public Object hello(){
        return "hello SpringBoot";
    }

    @RequestMapping("/getResource")
    public IMoocJSONResult getResource() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return IMoocJSONResult.ok(bean);
    }
}
