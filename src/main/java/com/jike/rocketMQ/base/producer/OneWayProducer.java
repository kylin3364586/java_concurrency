package com.jike.rocketMQ.base.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

/**
 * 发送单向消息
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月17日 16:00:00
 */
@Slf4j
public class OneWayProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //1.创建消息生产者producer,并指定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("kylin01_test_producer_group");
        //2.指定NameServer地址
        producer.setNamesrvAddr("192.168.20.60:9876;192.168.20.61:9876");
        //3.启动producer
        producer.start();
        for (int i = 0; i < 10; i++) {
            //4.创建消息对象，指定主题Topic、tag、消息内容
            Message message = new Message("kylin", "tag03",("Hello World" +i).getBytes());
            //5.发送消息
            producer.sendOneway(message);

            //睡眠一秒
            TimeUnit.SECONDS.sleep(1);
        }
        //6.关闭生产者producer
        producer.shutdown();
    }

}
