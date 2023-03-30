package com.ice.learning.socketLearning.a01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Title: MyInetAddressDemo1
 * @Auth: Ice
 * @Date: 2023/3/29 22:26
 * @Version: 1.0
 * @Desc:
 */

public class MyInetAddressDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("IIIce");
        System.out.println(address);

        String hostName = address.getHostName();
        System.out.println(hostName);

        String ip = address.getHostAddress();
        System.out.println(ip);

    }
}
