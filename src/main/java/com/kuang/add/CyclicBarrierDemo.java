package com.kuang.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 加法计数器
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-01-06- 16:25:00
 */
public class CyclicBarrierDemo {

    /**
     * 集齐七颗龙珠召唤神龙
     * 创建一个新的CyclicBarrier，当给定数量的参与方（线程）正在等待它时，它将跳闸，并且当屏障跳闸时，它会执行给定的屏障动作，由最后一个进入屏障的线程执行
     * @param args
     */
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙成功！！");
        });

        for (int i = 1; i <= 7; i++) {
            final int num = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"集齐了"+num+"颗龙珠");
                try {
                    cyclicBarrier.await();//等待 +1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
