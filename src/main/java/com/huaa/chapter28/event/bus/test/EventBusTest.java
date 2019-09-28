package com.huaa.chapter28.event.bus.test;

import com.huaa.chapter28.event.bus.AsyncEventBus;
import com.huaa.chapter28.event.bus.Bus;
import com.huaa.chapter28.event.bus.EventBus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/20 23:57
 */
public class EventBusTest {

    public static void main(String[] args) {
        Bus bus = new AsyncEventBus("TestBus", (ThreadPoolExecutor) Executors.newFixedThreadPool(10));
        bus.register(new SimpleSubscriber1());
        bus.register(new SimpleSubscriber2());
        bus.post("Hello");
        System.out.println("----------");
        bus.post("Hello test", "test");
        bus.close();
    }

}
