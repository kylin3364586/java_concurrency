package com.rchz.concurrency;


public class ThreadB extends Thread {

    private MyObject myObject;

    public ThreadB(MyObject myObject){
        this.myObject = myObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myObject.increase();
        }
    }
}
