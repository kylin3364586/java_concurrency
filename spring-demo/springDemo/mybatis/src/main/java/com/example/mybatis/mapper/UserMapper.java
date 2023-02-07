package com.example.mybatis.mapper;

import com.example.mybatis.bean.User;

/**
 * 使用XML映射语句
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-06- 11:16:00
 */
public interface UserMapper {

    User selectUser(String id);
}
