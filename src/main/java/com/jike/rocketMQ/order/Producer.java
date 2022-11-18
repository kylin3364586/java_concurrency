package com.jike.rocketMQ.order;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * 顺序消息生产者
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月17日 17:24:00
 */
@Slf4j
public class Producer {

    public static void main(String[] args) throws Exception {
        //1.创建消息生产者producer,并指定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("kylin01_test_producer_group");
        //2.指定NameServer地址
        producer.setNamesrvAddr("192.168.20.60:9876;192.168.20.61:9876");
        //3.启动producer
        producer.start();
        List<OrderStep> orderStepList = OrderStep.buildOrders();
        for (int i = 0; i < orderStepList.size(); i++) {
            String body = orderStepList.get(i) + "";
            //4.创建消息对象，指定主题Topic、tag、keys、消息内容
            Message message = new Message("order_kylin", "*", "i"+i, body.getBytes());
            /**
             * 参数一：消息对象
             * 参数二：消息队列选择器
             * 参数三：选择队列的业务标识（订单ID）
             */
            SendResult sendResult = producer.send(message, new MessageQueueSelector() {
                /**
                 *
                 * @param mqs 队列集合
                 * @param msg 消息对象
                 * @param arg 业务标识参数
                 * @return
                 */
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    long orderId = (long) arg;
                    long index = orderId % mqs.size();
                    return mqs.get((int) index);
                }
            }, orderStepList.get(i).getOrderId());
            log.info("发送结果："+sendResult);
        }
        //6.关闭生产者producer
        producer.shutdown();
    }
}
