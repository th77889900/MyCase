package com.example.th.netprogram.democase;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SockeServer {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8888);

        Socket socket = server.accept();

        System.out.println("接收到客户端信息");

        String msg = "你好";

        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        outputStream.writeUTF(msg);

        outputStream.flush();
        outputStream.close();

    }
}
