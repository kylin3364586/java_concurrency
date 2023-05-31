package com.kuang.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-05-30- 16:22:00
 */
public class UDPSendDemo02 {

    public static void main(String[] args) throws Exception {
        //创建socket ,port自己暴露的端口
        DatagramSocket socket = new DatagramSocket(9800);
        while (true) {
            //读取控制台输入
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String readLine = bufferedReader.readLine();
            byte[] bytes = readLine.getBytes();

            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("127.0.0.1"), 9666);
            socket.send(packet);
        }

    }
}
