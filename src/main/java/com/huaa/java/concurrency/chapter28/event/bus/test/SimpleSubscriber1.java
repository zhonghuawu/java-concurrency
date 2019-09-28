package com.huaa.java.concurrency.chapter28.event.bus.test;

import com.huaa.java.concurrency.chapter28.event.bus.Subscribe;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/20 23:58
 */
public class SimpleSubscriber1 {

    @Subscribe
    public void method1(String message) {
        System.out.println("===SimpleSubscriber1==method1===" + message);
    }

    @Subscribe(topic = "test")
    public void method2(String message) {
        System.out.println("===SimpleSubscriber1==method2===" + message);
    }

}
