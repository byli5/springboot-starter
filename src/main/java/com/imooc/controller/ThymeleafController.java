package com.imooc.controller;

import com.imooc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 */
@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("name","thymeleaf-imooc");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }

    public String test(ModelMap map){
        User user = new User();
        return null;
    }

}
