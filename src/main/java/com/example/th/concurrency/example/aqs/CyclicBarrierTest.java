package com.example.th.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierTest {

    public final static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
            final int num = i;
            TimeUnit.SECONDS.sleep(1);
            service.execute(() -> {
                try {
                    test(num);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        service.shutdown();
    }

    public static void test(int i) throws Exception {
        log.info("thread is ready " + i);
        try {
            barrier.await(2,TimeUnit.SECONDS);
        } catch (Exception e) {
            log.warn("exception    oooooo");
        }

        log.info("success run " + i);
    }
}
