package com.kuang.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-05-30- 15:29:00
 */
public class UDPServerDemo {

    public static void main(String[] args) throws Exception {

        byte[] bytes = new byte[1024];
        //数据报包
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
        //建立发送端数据报socket
        DatagramSocket socket = new DatagramSocket(9888);
        //阻塞接收
        socket.receive(packet);


        System.out.println(new String(packet.getData()));
        socket.close();
    }
}
