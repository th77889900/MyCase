package com.example.th.thread;

public class ThreadCase {

    public static void main(String[] args) {

        new Thread(() -> {

            System.out.println("hello");

        }).start();
    }
}
