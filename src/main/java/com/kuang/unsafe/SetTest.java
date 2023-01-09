package com.kuang.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-05- 20:53:00
 */
public class SetTest {

    public static void main(String[] args) {
        /**
         * 会出现并发修改异常
         * 解决方案：
         * 1. Set<String> set = Collections.synchronizedSet(new HashSet<>());
         * 2. Set<String> set = new CopyOnWriteArraySet(new HashSet<>());
         *
         * HashSet() 线程不安全且无序不可重复，是因为其底层是HashMap(), key是set中的元素，value是一个常量
         *
         *      public boolean add(E e) {
         *         return map.put(e, PRESENT)==null;
         *     }
         */
//        Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet(new HashSet<>());

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            }).start();
        }

    }
}
