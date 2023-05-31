package com.kuang.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 *
 * {@link java.net.InetAddress}
 *
 * @createTime 2023-05-29- 14:26:00
 */
public class NetAddress {


    public static void main(String[] args) {

        try {
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);

            InetAddress inetAddress2 = InetAddress.getByName("localhost");
            System.out.println(inetAddress2);

            InetAddress inetAddress3 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress3);

            InetAddress inetAddress4 = InetAddress.getLocalHost();
            System.out.println(inetAddress4);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
