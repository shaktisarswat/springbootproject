package com.spring.springbootproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @RequestMapping("/home")
//    @ResponseBody
    public String viewHome()
    {
        System.out.println("this is home page");
        return "home";
    }

    @RequestMapping("/")
//    @ResponseBody
    public String viewError()
    {
        System.out.println("this is error page");
        return "index";
    }


}
