package com.kuang.net;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-05-29- 15:43:00
 */
public class TCPServerDemo {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            serverSocket = new ServerSocket(8356);
            while (true){
                //接收
                socket = serverSocket.accept();
                //读取消息
                is = socket.getInputStream();
                //管道流
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1){
                    baos.write(buffer, 0, len);
                }
                System.out.println(baos.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != baos){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != socket){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(null != serverSocket){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
