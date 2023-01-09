package com.kuang.demo01;

/**
 * 多线程操作同一个资源
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-05- 13:47:00
 */
public class SaleTicketDemo01 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(()-> {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            },"A"
        ).start();
        new Thread(()-> {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            },"B"
        ).start();
        new Thread(()-> {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            },"C"
        ).start();
    }

}

class Ticket{
    //属性
    private int num = 30;

    //方法
    public synchronized void sale(){
        if(num > 0){
            System.out.println(Thread.currentThread().getName()+"卖出了："+ num-- +"张票，剩余："+num);
        }
    }
}
