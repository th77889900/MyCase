package com.example.th.concurrency.example.aqs.semaphorecase;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class SemaphoreTest {

    public static final int threadNo = 200;
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(3);
        ExecutorService service = Executors.newFixedThreadPool(500);

        for (int i = 0; i < threadNo; i++) {
            final int num = i;
            service.execute(() -> {
                try {
                    if (semaphore.tryAcquire())
                    test(num);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        log.info("{}", "finish");
        service.shutdown();
    }

    public static void test(int i) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}", i);
        Thread.sleep(100);
    }
}
