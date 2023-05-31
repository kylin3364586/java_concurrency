package com.kuang.net;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-05-29- 15:42:00
 */
public class TCPClientDemo {


    public static void main(String[] args) {

        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8356);
            os = socket.getOutputStream();
            os.write("hello, 你好啊!".getBytes());
            os.flush();
            //此处调用shutdownOutput()或者finally中调用close() 否则会报“连接拒绝”错误
            socket.shutdownOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            if(null != os){
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(null != socket){
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }

    }
}
