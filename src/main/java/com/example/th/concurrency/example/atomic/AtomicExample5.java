package com.example.th.concurrency.example.atomic;

import com.example.th.concurrency.annotations.UnThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@UnThreadSafe
public class AtomicExample5 {


    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    private static AtomicExample5 atomic5 = new AtomicExample5();

    public static void main(String[] args) {

        if (updater.compareAndSet(atomic5, 100, 120)) {
            log.info("count success 1: {}", atomic5.getCount());
        }

        if (updater.compareAndSet(atomic5, 100, 150)) {
            log.info("count success 2: {}", atomic5.getCount());
        }else {
            log.info("count failed: {}", atomic5.getCount());

        }
    }
}
