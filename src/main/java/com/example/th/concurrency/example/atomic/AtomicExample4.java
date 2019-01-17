package com.example.th.concurrency.example.atomic;

import com.example.th.concurrency.annotations.UnThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@UnThreadSafe
public class AtomicExample4 {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 2);
        count.compareAndSet(0, 1);
        count.compareAndSet(1, 4);
        count.compareAndSet(2, 5);
        count.compareAndSet(4, 3);
        count.compareAndSet(3, 9);
        log.info("count: {}", count);
    }
}
