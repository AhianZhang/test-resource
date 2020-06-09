package com.ahianzhang.xp.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ahianzhang
 * @version 1.0
 * @date 2020/6/8 10:05 PM
 **/
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer gender;
    private String address;
    private String createTime;
    private String updateTime;
}
