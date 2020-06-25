package com.ahianzhang.xp.demo.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ahianzhang
 * @version 1.0
 * @date 2020/6/8 10:05 PM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;
    private String name;
    private Integer gender;
    private String address;
    private String createTime;
    private String updateTime;
}
