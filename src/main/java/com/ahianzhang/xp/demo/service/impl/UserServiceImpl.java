package com.ahianzhang.xp.demo.service.impl;

import com.ahianzhang.xp.demo.dao.IUserMapper;
import com.ahianzhang.xp.demo.entity.User;
import com.ahianzhang.xp.demo.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 * @author ahianzhang
 * @version 1.0
 * @date 2020/6/8 10:10 PM
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {
    private final IUserMapper userDao;
    @Override
    public Integer createUser(User user) {
        if (user == null){
            log.warn("user is null");
            return 0;
        }
        Timestamp timestamp = Timestamp.from(Instant.now());
        user.setCreateTime(timestamp.toString());
        return userDao.createUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
