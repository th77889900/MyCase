package com.example.th.concurrency.example.aqs.countdownlancth;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CaseTest {

    public static final int threadNo = 200;
    public static void main(String[] args) throws InterruptedException {



        final CountDownLatch latch = new CountDownLatch(threadNo);
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < threadNo; i++) {
            final int num = i;
            service.execute(() -> {
                try {
                    test(num);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(10,TimeUnit.MILLISECONDS);
        log.info("{}", "finish");
        service.shutdown();
    }

    public static void test(int i) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}", i);
        Thread.sleep(100);
    }
}
