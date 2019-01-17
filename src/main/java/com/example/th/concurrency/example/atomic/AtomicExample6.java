package com.example.th.concurrency.example.atomic;

import com.example.th.concurrency.annotations.UnThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@UnThreadSafe
public class AtomicExample6 {

    private static AtomicBoolean isHappen = new AtomicBoolean();

    private static int clienttotal = 5000;

    private static int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Semaphore semaphore = new Semaphore(threadTotal);

        CountDownLatch countDownLatch = new CountDownLatch(clienttotal);

        for (int i = 0; i < clienttotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("ishepent: {}", isHappen.get());

    }

    private static void test() {
        if (isHappen.compareAndSet(true, false)) {
            log.info("execute。。。");
        }
    }
}
