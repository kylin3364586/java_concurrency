package com.example.mybatis.mapper;

import com.example.mybatis.bean.Person;
import org.apache.ibatis.annotations.Select;

/**
 * 使用注解
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-06- 15:17:00
 */
public interface PersonMapper {

    @Select("select * from person where id = #{id}")
    Person selectPerson(int id);
}
