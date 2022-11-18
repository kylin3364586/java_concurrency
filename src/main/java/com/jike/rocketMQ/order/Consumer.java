package com.jike.rocketMQ.order;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 顺序消息消费者
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月17日 17:25:00
 */
@Slf4j
public class Consumer {

    public static void main(String[] args) throws MQClientException {
        //1.创建消费者Consumer，指定消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("kylin01_test_producer_group");
        //2.指定NameServer地址
        consumer.setNamesrvAddr("192.168.20.60:9876;192.168.20.61:9876");
        //3.订阅主题Topic、tag(多个tag使用（tag1 || tag2）,全部使用（*）)
        consumer.subscribe("order_kylin", "*");
        //4.注册监听器（一个broker使用一个线程消费）
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                for (MessageExt me : msgs) {
                    log.info("线程名称：【" + Thread.currentThread().getName() + "】:" + new String(me.getBody()));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        //5.启动消费者Consumer
        consumer.start();
    }
}
