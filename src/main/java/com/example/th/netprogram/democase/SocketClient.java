package com.example.th.netprogram.democase;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8888);

        DataInputStream inputStream = new DataInputStream(client.getInputStream());

        String s = inputStream.readUTF();

        System.out.println(s);

        inputStream.close();
    }
}
