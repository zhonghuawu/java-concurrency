package com.huaa.java.concurrency.chapter23.latch;

import java.util.concurrent.TimeUnit;

public class CountDownLatch extends Latch {

    public CountDownLatch(int limit) {
        super(limit);
    }

    @Override
    public void await() throws InterruptedException {
        synchronized (this) {
            while (limit > 0) {
                this.wait();
            }
        }
    }

    @Override
    public void await(TimeUnit unit, long time) throws InterruptedException, WaitTimeoutException {
        if (time <= 0) {
            throw new IllegalArgumentException("The time is invalid.");
        }
        long remainingNanos = unit.toNanos(time);
        final long endNanos = System.nanoTime() + remainingNanos;
        synchronized (this) {
            while (limit > 0) {
                if (TimeUnit.NANOSECONDS.toMillis(remainingNanos) <= 0L) {
                    throw new WaitTimeoutException("The wait time over specify time.");
                }
                this.wait(TimeUnit.NANOSECONDS.toMillis(remainingNanos));
                remainingNanos = endNanos - System.nanoTime();
            }
        }

    }

    @Override
    public void countDown() {
        synchronized (this) {
            if (limit <= 0) {
                throw new IllegalStateException("all of task already arrived");
            }
            limit--;
            this.notifyAll();
        }
    }

    @Override
    public int getUnarrived() {
        return limit;
    }
}
