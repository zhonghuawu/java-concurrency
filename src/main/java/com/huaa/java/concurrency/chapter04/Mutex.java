package com.huaa.java.concurrency.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * Desc:
 *
 * @author zhonghua.wu
 * @date 2019/6/29 11:11
 */
public class Mutex {

    private final static Object MUTEX = new Object();

    public void accessResource() {
        synchronized (MUTEX) {
            try {
                TimeUnit.MINUTES.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Mutex mutex = new Mutex();
        for(int i=0; i<5; i++) {
            new Thread(mutex::accessResource).start();
        }
    }


}
