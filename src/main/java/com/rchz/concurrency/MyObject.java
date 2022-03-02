package com.rchz.concurrency;

public class MyObject {

    int counter = 0;

    public synchronized void increase(){
        while (counter != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter ++;
        System.out.println(counter);
        notify();
    }

    public synchronized void decrease(){
        while (counter == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter --;
        System.out.println(counter);
        notify();
    }

}
