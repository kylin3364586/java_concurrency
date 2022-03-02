package com.jike.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.List;

class SyncProducer {
    public static void main(String[] args) throws Exception{

        //注意maven引入的版本要和服务器的版本一致
        DefaultMQProducer producer = new DefaultMQProducer("test_sync_group");
        //我的虚拟机IP地址10.8.80.87
        producer.setNamesrvAddr("192.168.20.49:9876");
        producer.start();
//        for (int i=0; i<20; i++){
            //String topic, String tags, byte[] body
            Message message = new Message("TopicTest","TagA",new TestBean().toString().getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(message);
            System.out.printf("%s%n", sendResult);
//        }
        producer.shutdown();
    }
}

class Consumer {
    public static void main(String[] args) throws MQClientException {
        //指定组
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_sync_group");
        //指定服务器
        consumer.setNamesrvAddr("192.168.20.49:9876");
        // Subscribe one more more topics to consume.
        consumer.subscribe("TopicTest","*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                msgs.stream().forEach( messageExt -> {
                    try {
                        String s = new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET);
                        System.out.println(s.toString());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //运行消费者实例
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
