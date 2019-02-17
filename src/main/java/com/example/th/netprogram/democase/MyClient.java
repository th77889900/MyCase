package com.example.th.netprogram.democase;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class MyClient {

    public static void main(String[] args) throws IOException {

        DatagramSocket client = new DatagramSocket(6666);

        String msg = "server 你好";

        byte[] datas = msg.getBytes();

        DatagramPacket packet = new DatagramPacket(datas, datas.length, new InetSocketAddress("localhost", 8888));

        client.send(packet);

        client.close();
    }
}
