package com.rchz.concurrency3;

/*
    使用synchronized修饰代码块时，字节码层面是通过monitorenter和monitorexit指令来实现加锁和释放锁。
    当线程进入monitorenter指令后，线程会持有monitor对象，退出monitorexit指令后，线程会释放monitor对象。
 */
public class MyTest1 {

    private Object object = new Object();

    public void method(){
        synchronized(object){
            System.out.println("hello world");
            throw new RuntimeException();
        }
    }

    public void method2(){
        synchronized (object){
            System.out.println("welcome");
        }
    }
}
