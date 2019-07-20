package com.huaa.chapter28.event.bus;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/20 12:18
 */
public class AsyncEventBus extends EventBus {

    AsyncEventBus(String busName, EventExceptionHandler exceptionHandler, ThreadPoolExecutor executor) {
        super(busName, exceptionHandler, executor);
    }

    public AsyncEventBus(String busName, ThreadPoolExecutor executor) {
        this(busName, null, executor);
    }

    public AsyncEventBus(ThreadPoolExecutor executor) {
        this("default-async", null, executor);
    }

    public AsyncEventBus(EventExceptionHandler exceptionHandler, ThreadPoolExecutor executor) {
        this("default-async", exceptionHandler, executor);
    }

}
