package com.jike.demo;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年01月17日 16:59:00
 */
public class SonTest {

    public static void main(String[] args) {
//        Father f = new Father();
        Son f = new Son();
//        System.out.println(f.x);
    }
}

class Father {
    int x = 10;

    public Father() {
        this.print();
        x = 20;
    }

    public void print() {
        System.out.println("Father.x=" + x);
    }
}

class Son extends Father {
    int x = 30;

    public Son() {
        this.print();
        x = 40;
    }

    @Override
    public void print() {
        System.out.println("Son.x=" + x);
    }
}