package com.kuang.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-11- 10:30:00
 */
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
}
