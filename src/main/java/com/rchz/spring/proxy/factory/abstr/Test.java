package com.rchz.spring.proxy.factory.abstr;

import java.util.HashMap;
import java.util.HashSet;

public class Test {


    public static void main(String[] args) {
        DefaultAbsFactory defal = new DefaultAbsFactory();
        System.out.println(defal.getCar("bmw"));

    }
}
