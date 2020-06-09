package com.ahianzhang.xp.demo.service.impl;

import com.ahianzhang.xp.demo.dao.IUserMapper;
import com.ahianzhang.xp.demo.entity.User;
import com.ahianzhang.xp.demo.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ahianzhang
 * @version 1.0
 * @date 2020/6/8 10:10 PM
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserMapper userDao;
    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
