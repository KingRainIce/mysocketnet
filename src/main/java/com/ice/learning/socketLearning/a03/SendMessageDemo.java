package com.ice.learning.socketLearning.a03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @Title: SendMessageDemo
 * @Auth: Ice
 * @Date: 2023/3/30 19:18
 * @Version: 1.0
 * @Desc:
 */

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        MulticastSocket ms = new MulticastSocket();
        String s = "hello everyone";
        byte[] bytes = s.getBytes();
        InetAddress addresses = InetAddress.getByName("224.0.0.1");
        int port = 10000;

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, addresses, port);

        ms.send(packet);

        ms.close();

    }
}
