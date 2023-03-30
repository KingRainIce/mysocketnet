package com.ice.learning.socketLearning.a01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Title: SendMessageDemo
 * @Auth: Ice
 * @Date: 2023/3/30 10:08
 * @Version: 1.0
 * @Desc:
 */

public class SendMessageDemo {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            String s = "Hello!!!";
            byte[] bytes = s.getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 10086);

            socket.send(packet);

        } catch (Exception e) {
            System.out.println("error");

        }


    }
}
