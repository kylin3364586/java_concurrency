package com.kylin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 缓存击穿：缓存查不到，数据库也查不到          解决方案：1.增加请求过滤（过滤非法请求） 2.缓存空或者错误提示 3.使用布隆过滤器
 * 缓存穿透：泛指热key过期，请求进入到db        解决方案：1.db层加互斥锁 2.热key不过期，通过其他手段按需更新
 * 缓存雪崩：大量key同时过期，请求进入到db      解决方案：1.热key打散，过期时间加上随机数 2.热key不过期，通过其他手段按需更新 3.db层加互斥锁
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-03-02- 14:47:00
 */
@Slf4j
@RestController
@RequestMapping("t1")
public class CacheTestController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private JdbcTemplate jdbcTemplate;


    @GetMapping("getUserName")
    public String getUserName(){
//        String id = "0";
        String id = "2134161564";
        String username = null;
        if(!redisTemplate.hasKey(id)){//key不存在
            log.info("db get.......");
            List<Users> users = jdbcTemplate.queryForList("select * from user where id ="+ id, Users.class);
            if(!ObjectUtils.isEmpty(users) && users.size() > 0){
                username = users.get(0).getUsername();
            }
            if(!StringUtils.isEmpty(username)){
                log.info("redis save.......");
                redisTemplate.boundValueOps(id).set(username);
            }
        }else{
            log.info("redis get.......");
            username = (String)redisTemplate.boundValueOps(id).get();
        }
        return username;
    }
}
