package com.example.th.httpserver.server;

import org.springframework.context.expression.CachedExpressionEvaluator;
import org.springframework.http.converter.AbstractHttpMessageConverter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

    private ServerSocket server;

    public final static String CRLF = "\r\n";
    public final static String BLANK = " ";


    public static void main(String[] args) {

            Server server = new Server();
            server.start();

    }

    private void start() {
        try {
            server = new ServerSocket(8888);
            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receive() {
        try {
            Socket client = server.accept();
            StringBuilder sb = new StringBuilder();

            byte[] data = new byte[20480];

            int len = client.getInputStream().read(data);
            String requestInfo = new String(data, 0, len).trim();
            System.out.println(requestInfo);

            String responseContext = "hello world";

            StringBuilder response = new StringBuilder();
            response.append("http/1.1 200 OK").append(CRLF);
            response.append("Server:httpserver server/0.0.1").append(CRLF);
            response.append("Date:").append(new Date()).append(CRLF);
            response.append("Content-type:text/plain;charset=GBK").append(CRLF);
            response.append("Content-length:").append(responseContext.getBytes().length).append(CRLF);

            response.append(CRLF);

            response.append(responseContext);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            writer.write(response.toString());

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stop() {

    }
}
