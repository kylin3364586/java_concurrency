package com.rchz.concurrency3;

/*
    死锁：线程1等待线程2互斥持有的资源，线程2也在等待线程1互斥持有的资源，两个线程都无法继续执行
    活锁：线程持续重试一个总是失败的操作，导致无法继续执行
    饿死：线程一直被调度器延迟访问其赖以执行的资源，可能由于线程优先级较低导致以止获取不到资源以进行执行
 */

public class MyTest6 {

    private Object obj1 = new Object();
    private Object obj2 = new Object();

    public void myMethod1(){
        synchronized(obj1){
            synchronized (obj2){
                System.out.println("method1");
            }
        }
    }
    public void myMethod2(){
        synchronized (obj2){
            synchronized (obj1){
                System.out.println("method2");
            }
        }
    }

    public static void main(String[] args) {
        MyTest6 myTest6 = new MyTest6();

        Runnable runnable1 = () ->{
            while (true){
                myTest6.myMethod1();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = () ->{
            while (true){
                myTest6.myMethod2();

                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){

                }
            }

        };

        Thread thread1 = new Thread(runnable1, "Thread11");
        Thread thread2 = new Thread(runnable2, "Thread22");

        thread1.start();
        thread2.start();
    }


}
