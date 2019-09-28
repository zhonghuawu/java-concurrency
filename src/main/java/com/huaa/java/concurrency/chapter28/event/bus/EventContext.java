package com.huaa.java.concurrency.chapter28.event.bus;

import java.lang.reflect.Method;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/20 10:49
 */

public interface EventContext {
    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();
}
