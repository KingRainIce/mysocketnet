package com.ice.learning.socketLearning.a04;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Title: Clint
 * @Auth: Ice
 * @Date: 2023/3/30 23:25
 * @Version: 1.0
 * @Desc:
 */

public class Clint {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);

        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());

        os.close();
        socket.close();

    }
}
