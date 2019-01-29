package com.example.th.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) {
        FutureTask task = new FutureTask<Object>(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                log.info("zaixhignixng ");
                Thread.sleep(5000);
                return "ss";
            }
        });

        new Thread(task).start();
        log.info("开始执行----");

        try {
            Object o = task.get();
            log.info("object: " + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        log.info("执行完成。。。。");

    }
}
