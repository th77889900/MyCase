package com.example.th.concurrency.example.count;

import com.example.th.concurrency.annotations.UnThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@UnThreadSafe
public class ConcurrencyExample1 {

    private static int clienttotal = 5000;

    private static int threadTotal = 200;

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Semaphore semaphore = new Semaphore(threadTotal);

        CountDownLatch countDownLatch = new CountDownLatch(clienttotal);

        for (int i = 0; i < clienttotal; i++) {


            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("err: ", e);
                }
            });
            countDownLatch.countDown();
        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("count: {}" + count);
    }

    private static void add() {
        count++;
    }
}
