package com.kuang.net;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-05-30- 10:16:00
 */
public class TCPClientDemo02 {

    public static void main(String[] args) throws Exception {

        //建立socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9800);
        OutputStream os = socket.getOutputStream();
        //读取文件
        FileInputStream inputStream = new FileInputStream(new File("test.jpg"));
        //写出
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }
        //写出完毕
        socket.shutdownOutput();

        //接收服务器响应
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while (( len2 = is.read(buffer2)) != -1){
            baos.write(buffer2, 0, len2);
        }
        System.out.println("服务的响应结果：" + baos.toString());

        baos.close();
        is.close();

        inputStream.close();
        os.close();
        socket.close();
    }
}
