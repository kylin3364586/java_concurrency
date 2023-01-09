package com.kuang.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-06- 09:52:00
 */
public class MapTest {
    public static void main(String[] args) {

        /**
         * HashMap 会出现并发修改问题
         * 解决方案：
         * 1.Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
         * 2.Map<String,String> map = new ConcurrentHashMap<>();
         */
//        Map<String,String> map = new HashMap<>();
//        Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();

        }
    }
}
