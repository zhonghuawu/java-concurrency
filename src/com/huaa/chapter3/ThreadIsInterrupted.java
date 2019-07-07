package com.huaa.chapter3;

import java.util.concurrent.TimeUnit;

/**
 * Desc:
 *
 * @author zhonghua.wu
 * @date 2019/6/23 15:02
 */
public class ThreadIsInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.printf("I an be interrupted ? %s\n", isInterrupted());
                    }

                }
            }
        };

        thread.setDaemon(true);

        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
        thread.interrupt();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
    }
}
