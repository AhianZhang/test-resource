package com.ahianzhang.xp.demo.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ahianzhang
 * @version 1.0
 * @date 2020/6/8 10:11 PM
 **/
@Mapper
public interface IUserMapper {
    /**
     * dao
     * @param user user
     * @return affect mysql table rows
     */
    Integer createUser(User user);

    /**
     * get all users
     * @return user list
     */
    List<User> getUsers();
}
