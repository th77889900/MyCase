package com.example.th.netprogram.democase;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
public class Demo1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        String hostName = localHost.getHostName();
        log.info(String.valueOf(localHost));
        log.info(hostName);

        InetAddress byName = InetAddress.getByName("www.hahasdafasdfasdf.com");
        String address = byName.getHostAddress();
        String name = byName.getHostName();

        log.info(byName.toString());
        log.info(address);
        log.info(name);
    }
}
