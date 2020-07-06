package com.lexue.controller;

import com.lexue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 25610 on 2020/7/3.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/getUser")
    public String getUser(){
        String user = userService.getUser();
        return user;
    }
}
