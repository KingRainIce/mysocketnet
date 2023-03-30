package com.ice.learning.socketLearning.a01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Title: ReceiveMessageDemo
 * @Auth: Ice
 * @Date: 2023/3/30 10:24
 * @Version: 1.0
 * @Desc:
 */

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(10086);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        socket.receive(dp);

        byte[] data = dp.getData();
        int length = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();

        System.out.println(new String(data,0,length));

        socket.close();

    }
}
