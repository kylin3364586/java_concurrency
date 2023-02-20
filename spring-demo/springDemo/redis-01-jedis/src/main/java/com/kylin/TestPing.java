package com.kylin;

import redis.clients.jedis.Jedis;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-20- 14:51:00
 */
public class TestPing {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());

        jedis.close();
    }
}
