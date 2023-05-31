package com.kuang.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-05-30- 10:16:00
 */
public class TCPServerDemo02 {

    public static void main(String[] args) throws Exception {
        //及案例socket连接
        ServerSocket serverSocket = new ServerSocket(9800);
        //等待客户端连接
        Socket socket = serverSocket.accept();
        //获取输入流
        InputStream inputStream = socket.getInputStream();
        //流写出到文件
        FileOutputStream fileOutputStream = new FileOutputStream(new File("test2.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer, 0, len);
        }

        //给客户端响应
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("接收完毕 over！".getBytes());

        outputStream.close();

        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
