package com.huaa.chapter26.worker.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/18 0:22
 */
public class Worker extends Thread {
    private final ProductionChannel channel;
    private final static Random random = new Random(System.currentTimeMillis());

    public Worker(String workerName, ProductionChannel channel) {
        super(workerName);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Production production = channel.takeProduction();
                System.out.println(getName() + " process the " + production);
                production.create();
                TimeUnit.SECONDS.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
