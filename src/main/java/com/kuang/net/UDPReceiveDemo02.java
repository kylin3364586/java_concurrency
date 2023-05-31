package com.kuang.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-05-30- 16:23:00
 */
public class UDPReceiveDemo02 {

    public static void main(String[] args) throws Exception {

        //创建socket ,port自己暴露的端口
        DatagramSocket socket = new DatagramSocket(9666);

       while (true){
           byte[] bytes = new byte[1024];
           DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
           socket.receive(packet);

           byte[] data = packet.getData();
           System.out.println(new String(data, 0, data.length));
       }
    }
}
