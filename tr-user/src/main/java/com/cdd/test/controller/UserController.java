package com.cdd.test.controller;

import com.cdd.test.pojo.User;
import com.cdd.test.service.UserService;
import com.cdd.test.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenyadong
 * @create 2022-09-28-20:18
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody User user){
        return userService.login(user);
    }
    
    @PostMapping("/list")
    public R list(){
        return userService.list();
    }

    @GetMapping("/test")
    public void test(){
        System.out.println("aaaaa");
    }

}
