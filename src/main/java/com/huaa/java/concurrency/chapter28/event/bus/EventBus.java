package com.huaa.java.concurrency.chapter28.event.bus;

import java.util.concurrent.Executor;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/20 10:42
 */
public class EventBus implements Bus {

    private final Registry registry = new Registry();
    private String busName;
    private final static String DEFAULT_BUS_NAME = "default";

    private final static String DEFAULT_TOPIC = "default-topic";

    private final Dispatcher dispatcher;

    public EventBus() {
        this(DEFAULT_BUS_NAME);
    }

    public EventBus(String name) {
        this(name, null, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public EventBus(EventExceptionHandler exceptionHandler) {
        this(DEFAULT_BUS_NAME, exceptionHandler, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public EventBus(String busName, EventExceptionHandler exceptionHandler, Executor executor) {
        this.busName = busName;
        this.dispatcher = Dispatcher.newDispatcher(exceptionHandler, executor);
    }

    @Override
    public void register(Object subscriber) {
        this.registry.bind(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        this.registry.unbind(subscriber);
    }

    @Override
    public void post(Object event) {
        this.post(event, DEFAULT_TOPIC);
    }

    @Override
    public void post(Object event, String topic) {
        this.dispatcher.dispatch(this, registry, event, topic);
    }

    @Override
    public void close() {
        this.dispatcher.close();
    }

    @Override
    public String getBusName() {
        return this.busName;
    }
}
