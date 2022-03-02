package com.rchz.concurrency3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    public static void print(String str){
        System.out.println("result:" + str);
    }


    public static void main(String[] args) {
//        List<String> list = Arrays.asList("a","b","c","d");
//        for (String s : list){
//            Test.print(s);
//        }
//
//        list.forEach(s -> Test.print(s));
//
//        list.forEach(Test::print);

         Order stu1 = new  Order(22);
         Order stu2 = new  Order(33);
         Order stu3 = new  Order(44);
         Order stu4 = new  Order(55);
         Order stu5 = new  Order(66);
         Order stu6 = new  Order(77);

        List<Order> data = new ArrayList<>();
        data.add(stu1);
        data.add(stu2);
        data.add(stu3);
        data.add(stu4);
        data.add(stu5);
        data.add(stu6);

        int totalMoney = data.stream().map(Order::getMoney).reduce((m1, m2) -> m1 + m2).get();
        System.out.println(totalMoney);
    }
}

class Order{
    int money;

    public Order(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
