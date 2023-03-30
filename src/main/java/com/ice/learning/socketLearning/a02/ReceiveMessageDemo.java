package com.ice.learning.socketLearning.a02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Title: ReceiveMessageDemo
 * @Auth: Ice
 * @Date: 2023/3/30 13:51
 * @Version: 1.0
 * @Desc:
 */

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(10086);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        while (true) {
            ds.receive(dp);

            byte[] data = dp.getData();
            int len = dp.getLength();
            String ip = dp.getAddress().getHostAddress();
            String name = dp.getAddress().getHostName();

            System.out.println(ip + "  " + name + " : " + new String(data, 0, len));

        }

    }
}
