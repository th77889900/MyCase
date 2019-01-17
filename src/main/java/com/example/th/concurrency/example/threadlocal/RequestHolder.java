package com.example.th.concurrency.example.threadlocal;

public class RequestHolder {
    private final static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void add(long id) {
        threadLocal.set(id);
    }

    public static Long get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
