package com.jike.rocketMQ.order;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月17日 17:26:00
 */
@Data
public class OrderStep {
    private Long orderId;
    private String desc;

    @Override
    public String toString() {
        return "OrderStep{" +
                "orderId=" + orderId +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static List<OrderStep> buildOrders(){
        List<OrderStep> list = new ArrayList<>();

        OrderStep orderStep = new OrderStep();
        orderStep.setOrderId(1390L);
        orderStep.setDesc("创建");
        list.add(orderStep);

        orderStep = new OrderStep();
        orderStep.setOrderId(1551L);
        orderStep.setDesc("创建");
        list.add(orderStep);

        orderStep = new OrderStep();
        orderStep.setOrderId(1000L);
        orderStep.setDesc("创建");
        list.add(orderStep);

        orderStep = new OrderStep();
        orderStep.setOrderId(1390L);
        orderStep.setDesc("付款");
        list.add(orderStep);

        orderStep = new OrderStep();
        orderStep.setOrderId(1551L);
        orderStep.setDesc("付款");
        list.add(orderStep);

        orderStep = new OrderStep();
        orderStep.setOrderId(1551L);
        orderStep.setDesc("消息");
        list.add(orderStep);

        orderStep = new OrderStep();
        orderStep.setOrderId(1000L);
        orderStep.setDesc("付款");
        list.add(orderStep);

        orderStep = new OrderStep();
        orderStep.setOrderId(1000L);
        orderStep.setDesc("完成");
        list.add(orderStep);

        orderStep = new OrderStep();
        orderStep.setOrderId(1390L);
        orderStep.setDesc("完成");
        list.add(orderStep);

        orderStep = new OrderStep();
        orderStep.setOrderId(1551L);
        orderStep.setDesc("完成");
        list.add(orderStep);

        return list;
    }

}
