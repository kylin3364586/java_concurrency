package com.kuang.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-09- 10:25:00
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache2 myCache = new MyCache2();
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }

}
//加锁
class MyCache2{
    private volatile Map<String, Object> map = new HashMap<>();
    //读写锁
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //一个线程写入
    public void put(String key, Object obj){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,obj);
            System.out.println(Thread.currentThread().getName()+"写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    //多个线程读取
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

//自定义缓存
class MyCache{
    Map<String, Object> map = new HashMap<>();

    //写入
    public void put(String key, Object obj){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,obj);
        System.out.println(Thread.currentThread().getName()+"写入完成");
    }

    //读取
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取完成");
    }
}
