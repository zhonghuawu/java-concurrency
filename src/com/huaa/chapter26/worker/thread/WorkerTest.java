package com.huaa.chapter26.worker.thread;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/18 0:31
 */
public class WorkerTest {

    public static void main(String[] args) {
        final ProductionChannel channel = new ProductionChannel(5);
        AtomicInteger productionNo = new AtomicInteger();
        IntStream.range(1, 8).forEach(i -> {
            new Thread(() -> {
                while (true) {
                    channel.offerProduction(new Production(productionNo.getAndIncrement()));
                    try {
                        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
    }
}
