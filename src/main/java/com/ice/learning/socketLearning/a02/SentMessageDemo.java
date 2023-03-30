package com.ice.learning.socketLearning.a02;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @Title: ReceiveMessageDemo
 * @Auth: Ice
 * @Date: 2023/3/30 13:44
 * @Version: 1.0
 * @Desc:
 */

public class SentMessageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("please enter the words");
            String line = sc.nextLine();
            if ("886".equals(line)) {
                break;
            }
            byte[] bytes = line.getBytes();

            InetAddress address = InetAddress.getByName("127.0.0.1");
            int port = 10086;
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, port);
            ds.send(datagramPacket);
        }

        ds.close();

    }
}
