package com.huaa.java.concurrency.chapter26.worker.thread;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/18 0:21
 */
public class ProductionChannel {

    private final static int MAX_PROD = 100;

    private final Production[] productionQueue;

    private int tail;
    private int head;
    private int total;

    private final Worker[] workers;

    public ProductionChannel(int workSize) {
        this.workers = new Worker[workSize];
        this.productionQueue = new Production[MAX_PROD];
        for (int i = 0; i < workSize; i++) {
            this.workers[i] = new Worker("Worker-" + i, this);
            this.workers[i].start();
        }
    }


    public void offerProduction(Production production) {
        synchronized (this) {
            while (total >= productionQueue.length) {
                try {
                    this.wait();
                } catch (InterruptedException ignore) {
                }
            }
            productionQueue[tail] = production;
            tail = (tail + 1) % productionQueue.length;
            total++;
            this.notifyAll();
        }
    }

    public Production takeProduction() {
        synchronized (this) {
            while (total <= 0) {
                try {
                    this.wait();
                } catch (InterruptedException ignore) {
                }
            }
            Production prod = productionQueue[head];
            head = (head + 1) % productionQueue.length;
            total--;
            this.notifyAll();
            return prod;
        }
    }

}
