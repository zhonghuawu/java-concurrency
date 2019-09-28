package com.huaa.java.concurrency.chapter28.event.bus;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/20 10:49
 */
public interface EventExceptionHandler {
    void handle(Throwable cause, EventContext context);
}
