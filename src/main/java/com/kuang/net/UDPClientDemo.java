package com.kuang.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-05-30- 15:29:00
 */
public class UDPClientDemo {

    public static void main(String[] args) throws Exception {
        //socket连接地址
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        String data = "一个UDP消息！";
        //数据报包
        DatagramPacket packet = new DatagramPacket(data.getBytes(), 0, data.getBytes().length, inetAddress, 9888);
        //建立发送端数据报socket
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);

        socket.close();
    }
}
