package com.example.springbootdocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kylin
 * @time 2023/9/21 13:52
 */
@RestController
public class TestController {

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    @GetMapping("/getAccessNum")
    public String getAccessNum(){
        Long increment = stringRedisTemplate.opsForValue().increment("access_num");
        return "当前访问数量："+ increment;
    }
}
