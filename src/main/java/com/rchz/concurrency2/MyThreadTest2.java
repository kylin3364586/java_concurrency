package com.rchz.concurrency2;

public class MyThreadTest2 {

    public static void main(String[] args) {
        Test t = new Test();

        Thread t1 = new Thread1(t);
        Thread t2 = new Thread2(t);

        t1.start();
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

}

class Test{
    public synchronized void hello(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }

    public synchronized void world(){
        System.out.println("world");
    }
}

class Thread1 extends Thread{
    private Test t;
    public Thread1(Test t){
        this.t = t;
    }

    @Override
    public void run() {
        t.hello();
    }
}

class Thread2 extends Thread{
    private Test t;
    public Thread2(Test t){
        this.t = t;
    }

    @Override
    public void run() {
        t.world();
    }
}

