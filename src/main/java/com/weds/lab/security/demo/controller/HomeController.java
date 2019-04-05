package com.weds.lab.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 主页
 *
 * @author liudw
 * @date 2019-04-04 15:00
 **/
@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String homeUI() {
        return "home";
    }

    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "test";
    }
}
