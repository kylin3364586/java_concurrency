package com.kuang.single;

/**
 * 单例模式：饿汉式
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-12- 16:22:00
 */
public class Hungry {

    //无参构造私有化，防止外部创建对象
    private Hungry() {

    }

    private static final Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }


}
