package com.huaa.java.concurrency.chapter29.event.driven;

import com.huaa.java.concurrency.chapter29.event.driven.exception.MessageMatcherException;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:16
 */
public class EventDispatcher implements DynamicRouter<Message> {

    private final Map<Class<? extends Message>, Channel> routerTable;

    public EventDispatcher() {
        this.routerTable = new HashMap<>();
    }


    @Override
    public void registerChannel(Class<? extends Message> messageType, Channel<? extends Message> channel) {
        this.routerTable.put(messageType, channel);
    }

    @Override
    public void dispatch(Message message) {
        if (routerTable.containsKey(message.getType())) {
            routerTable.get(message.getType()).dispatch(message);
        } else {
            throw new MessageMatcherException("Can't match the channel for [" + message.getType() + "] type");
        }

    }
}
