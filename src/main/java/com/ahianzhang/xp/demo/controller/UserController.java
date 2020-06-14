package com.ahianzhang.xp.demo.controller;

import com.ahianzhang.xp.demo.entity.User;
import com.ahianzhang.xp.demo.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

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
    public ResponseEntity<User> createUser(@RequestBody  User user, WebRequest request){
        userService.createUser(user);
        user.setId(user.getId());
        return ResponseEntity.ok(user);
    }
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> userList = userService.getUsers();

        return  ResponseEntity.ok(userList);
    }
}
