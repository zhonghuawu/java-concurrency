package com.huaa.chapter2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Desc:
 *
 * @author zhonghua.wu
 * @date 2019/6/23 14:23
 */
public class ThreadCounter extends Thread {

    public static void main(String[] args) {
        try {
            while (true) {
                new ThreadCounter().start();
            }
        } catch (Throwable t) {
            System.out.println("failed at ->> " + counter.get());
        }
    }

    private static AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            System.out.println("The " + counter.getAndIncrement() + " thread be created.");
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
