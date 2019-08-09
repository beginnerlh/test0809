package com.bittech.controller;

import com.bittech.po.User;
import com.bittech.service.UserService;
import com.bittech.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private UserService userService = new UserServiceImpl();

    @RequestMapping(value = "/queryUser")
    public ModelAndView queryUser(){

        List<User> userList = null;
        try {
            userList = userService.queryUserService();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userListKey",userList);
        modelAndView.setViewName("showuser");
        return modelAndView;
    }
}
