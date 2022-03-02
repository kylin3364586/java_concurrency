package com.rchz.spring.proxy;

public class Demo {


    private int a = 1;

    protected void testMethod(){

    }
    private static int getIndex(){
        return 2;
    }

    public void a(){
        int c = getIndex();
    }

}
