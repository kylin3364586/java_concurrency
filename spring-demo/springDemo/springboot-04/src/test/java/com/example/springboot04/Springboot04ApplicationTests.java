package com.example.springboot04;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot04ApplicationTests {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void selectList(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        list.forEach(stringObjectMap -> {
            System.out.println(stringObjectMap.get("id") +"----------"+stringObjectMap.get("username"));
        });
    }


    @Autowired
    private DataSource dataSource;

    @Test
    public void getDataSourceInfo(){
        System.out.println(dataSource.getClass());
    }



    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest(){
        //获取Redis连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();

        redisTemplate.opsForValue().set("mykey","中文kylin");
        System.out.println(redisTemplate.opsForValue().get("mykey"));

    }


}
