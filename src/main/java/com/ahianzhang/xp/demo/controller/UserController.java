package com.ahianzhang.xp.demo.controller;

import com.ahianzhang.xp.demo.entity.User;
import com.ahianzhang.xp.demo.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ahianzhang
 * @version 1.0
 * @date 2020/6/8 10:01 PM
 **/
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    @PostMapping
    public void createUser(User user){
        userService.createUser(user);
    }
    @GetMapping
    public List<User> getUsers(){
     return userService.getUsers();
    }
}
