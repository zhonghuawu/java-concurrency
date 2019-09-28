package com.huaa.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * Desc:
 *
 * @author zhonghua.wu
 * @date 2019/6/29 14:59
 */
public class ThreadGroupEnumerateThreads {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup myGroup = new ThreadGroup("MyGroup");
        Thread thread = new Thread(myGroup, ()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "MyThread");
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        Thread[] list = new Thread[mainGroup.activeCount()];
        int recurseSize = mainGroup.enumerate(list);
        System.out.println(recurseSize);

        recurseSize = mainGroup.enumerate(list, false);
        System.out.println(recurseSize);

        System.out.println(myGroup.getParent());
        System.out.println(mainGroup.getParent());
        System.out.println(mainGroup.getParent().getParent());
        System.out.println("---");
        mainGroup.list();
        System.out.println("---");

        thread.interrupt();

        myGroup.setMaxPriority(12);

        thread.getUncaughtExceptionHandler();

    }

}
