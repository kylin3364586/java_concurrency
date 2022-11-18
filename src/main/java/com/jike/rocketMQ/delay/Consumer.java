package com.jike.rocketMQ.delay;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * 接收延迟消息
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月17日 16:11:00
 */
@Slf4j
public class Consumer {
    public static void main(String[] args) throws MQClientException {
        //1.创建消费者Consumer，指定消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("kylin01_test_producer_group");
        //2.指定NameServer地址
        consumer.setNamesrvAddr("192.168.20.60:9876;192.168.20.61:9876");
        //3.订阅主题Topic、tag(多个tag使用（tag1 || tag2）,全部使用（*）)
        consumer.subscribe("delay_kylin","tag01");
        //4.设置回调函数，处理消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            //接收消息内容
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt me: msgs) {
                    log.info("消息id：{},延迟时间：{}", me.getMsgId(), (System.currentTimeMillis() - me.getStoreTimestamp()));
                }
//                log.info("消费信息：{}", msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //5.启动消费者Consumer
        consumer.start();
    }
}
