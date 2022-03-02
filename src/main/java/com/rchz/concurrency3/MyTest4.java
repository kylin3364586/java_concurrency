package com.rchz.concurrency3;

public class MyTest4 {

    private Object object = new Object();

    public void method(Object object){
        synchronized(object){
            System.out.println(object);
        }
    }
}
