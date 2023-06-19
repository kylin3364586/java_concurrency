package com.rchz.test;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-06-13- 10:39:00
 */
public class Test2 {

    public void aa(){
        //锁class对象
        //锁代码块，通过monitorenter、monitorexit实现的锁
        synchronized (Test2.class){

        }
    }
}
