package com.ahianzhang.xp.demo.service;

import com.ahianzhang.xp.demo.entity.User;

import java.util.List;

/**
 * @author ahianzhang
 * @version 1.0
 * @date 2020/6/8 10:04 PM
 **/
public interface IUserService {
    /**
     * create user
     * @param user user
     */
    public void createUser(User user);

    /**
     * query all users
     * @return user list
     */
    List<User> getUsers();
}
