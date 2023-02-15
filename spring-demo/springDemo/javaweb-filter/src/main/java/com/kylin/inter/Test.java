package com.kylin.inter;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-15- 14:51:00
 */
public class Test {

    public static void main(String[] args) {
        //1.实例化接口必须要重写所有方法。
        MyInterface myInterface = new MyInterface() {
            @Override
            public void A() {
            }
            @Override
            public void B() {
            }
            @Override
            public void C() {
                System.out.println("C方法执行");
            }
            @Override
            public void D() {
            }
            @Override
            public void E() {
            }
        };
        //2.在接口之外添加一层抽象类，实例化这个抽象类，可以根据需求重写部分方法，代码更简洁
        MyInterface myInterface1 = new AbsMyInterface() {
            @Override
            public void C() {
                System.out.println("C方法执行");
            }
        };

        myInterface.C();
        myInterface1.C();

    }

}
