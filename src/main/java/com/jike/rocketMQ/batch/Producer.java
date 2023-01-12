package com.jike.rocketMQ.batch;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 发送批量消息
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年11月17日 15:34:00
 */
@Slf4j
public class Producer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //1.创建消息生产者producer,并指定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("kylin01_test_producer_group");
        //2.指定NameServer地址
        producer.setNamesrvAddr("192.168.20.60:9876;192.168.20.61:9876");
        //3.启动producer
        producer.start();

        List<Message> messageList = new ArrayList<>();
        //4.创建消息对象，指定主题Topic、tag、消息内容
        Message message = new Message("batch_kylin", "tag01",("Hello World1").getBytes());
        Message message2 = new Message("batch_kylin", "tag01",("Hello World2").getBytes());
        Message message3 = new Message("batch_kylin", "tag01",("Hello World3").getBytes());
        messageList.add(message);
        messageList.add(message2);
        messageList.add(message3);

        //5.发送消息
        SendResult result = producer.send(messageList);
        //输出发送结果
        SendStatus sendStatus = result.getSendStatus();
        String msgId = result.getMsgId();
        MessageQueue messageQueue = result.getMessageQueue();
        log.info("输出发送结果：sendStatus：{},msgId：{},messageQueue：{}",
                sendStatus,
                msgId,
                messageQueue);
        //睡眠一秒
        TimeUnit.SECONDS.sleep(1);
        //6.关闭生产者producer
        producer.shutdown();
    }

}