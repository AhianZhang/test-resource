package com.ahianzhang.xp.demo.user;

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
public class UserService {
    private final IUserMapper userDao;

    public Integer createUser(User user) {
        if (user == null){
            log.warn("user is null");
            throw new IllegalArgumentException("user cannot be null");
        }
        Timestamp timestamp = Timestamp.from(Instant.now());
        user.setCreateTime(timestamp.toString());
        return userDao.createUser(user);
    }


    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
