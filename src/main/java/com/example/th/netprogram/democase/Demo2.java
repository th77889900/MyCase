package com.example.th.netprogram.democase;

import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;

public class Demo2 {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("https://loaclhost/8080/a/n?w=12");

        String protocol = url.getProtocol();
        String host = url.getHost();
        String path = url.getPath();
        String file = url.getFile();
        String authority = url.getAuthority();

        System.out.println(protocol);
        System.out.println(host);
        System.out.println(path);
        System.out.println(file);
        System.out.println(authority);

    }
}
