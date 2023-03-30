package com.ice.learning.socketLearning.a04;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Title: Server
 * @Auth: Ice
 * @Date: 2023/3/30 23:25
 * @Version: 1.0
 * @Desc:
 */

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(10000);

        Socket accept = socket.accept();
        InputStream is = accept.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);

        int b = 0;
        while ((b = reader.read()) != -1){
            System.out.println((char) b);
        }
        accept.close();
        socket.close();



    }
}
