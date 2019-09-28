package com.huaa.java.concurrency.chapter29.event.driven.async;

import com.huaa.java.concurrency.chapter29.event.driven.Channel;
import com.huaa.java.concurrency.chapter29.event.driven.Event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:34
 */
public abstract class AsyncChannel implements Channel<Event> {

    private final ExecutorService executorService;

    public AsyncChannel() {
        this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));
    }

    public AsyncChannel(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public final void dispatch(Event message) {
        executorService.submit(()->this.handle(message));
    }

    protected abstract void handle(Event message);

    void stop() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}
