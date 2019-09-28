package com.huaa.java.concurrency.chapter29.event.driven.async;

import com.huaa.java.concurrency.chapter29.event.driven.Channel;
import com.huaa.java.concurrency.chapter29.event.driven.DynamicRouter;
import com.huaa.java.concurrency.chapter29.event.driven.Event;
import com.huaa.java.concurrency.chapter29.event.driven.exception.MessageMatcherException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:38
 */
public class AsyncEventDispatcher implements DynamicRouter<Event> {

    private final Map<Class<? extends Event>, AsyncChannel> routerTable;

    public AsyncEventDispatcher() {
        this.routerTable = new ConcurrentHashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Event> messageType, Channel<? extends Event> channel) {
        if (!(channel instanceof AsyncChannel)) {
            throw new IllegalArgumentException("The channel must be AsyncChannel Type.");
        }
        this.routerTable.put(messageType, (AsyncChannel) channel);
    }

    @Override
    public void dispatch(Event message) {
        if (routerTable.containsKey(message.getType())) {
            routerTable.get(message.getType()).dispatch(message);
        } else {
            throw new MessageMatcherException("Can't match the channal for [" + message.getType() + "] type");
        }
    }

    public void shutdown() {
        routerTable.values().forEach(AsyncChannel::stop);
    }

}
