package com.lexue.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 25610 on 2020/7/3.
 */
@RestController
public class UserController {

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(){
        System.out.println("user");
        return "user";
    }
}
