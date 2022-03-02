package com.rchz.concurrency3;

import javafx.util.Builder;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class MyTest5 {

    private Object o = new Object();
    public void method(){

        synchronized (o){
            System.out.println(1);
        }
        synchronized (o){
            System.out.println(2);
        }
        synchronized (o){
            System.out.println(3);
        }
    }

    public static void main(String[] args) {
        Callable<MyTest5> aNew = MyTest5::new;
        try {
            aNew.call().method();
        } catch (Exception e) {
            e.printStackTrace();
        }
        double five = DoubleUtils.mul(DoubleUtils.div(11000,19),5)-440.66;
        double sex = DoubleUtils.mul(DoubleUtils.div(11000,21),21.5)-440.66 + DoubleUtils.mul(DoubleUtils.div(11000,21),0.15);
        System.out.println(sex);
        System.out.println(sex+five);
    }
}


