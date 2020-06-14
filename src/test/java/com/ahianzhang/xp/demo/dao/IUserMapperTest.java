package com.ahianzhang.xp.demo.dao;

import com.ahianzhang.xp.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * @author ahianzhang
 * TODO: 2020/6/9  查看 @MyBatisTest 的回滚机制
 * 每个方法结束后会回滚
 */
@MybatisTest
class IUserMapperTest {
    @Autowired
    private IUserMapper userDao;

    @Test
    void should_pass_when_insert_new_user() {
        User user = new User(null,"sam",1,"北京", Instant.now().toString(),Instant.now().toString());
        Integer affectRows = userDao.createUser(user);
        assertThat(affectRows,is(1));
    }

    @Test
    void should_return_users_when_query_all_user() {
        User user = new User(null,"sam",1,"北京", Instant.now().toString(),Instant.now().toString());
        userDao.createUser(user);
        List<User> users = userDao.getUsers();
       assertThat(users,is(not(empty())));
    }
}