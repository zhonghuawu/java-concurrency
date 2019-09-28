package com.huaa.java.concurrency.chapter29.event.driven.async;

import com.huaa.java.concurrency.chapter29.event.driven.Event;
import com.huaa.java.concurrency.chapter29.event.driven.EventDispatcherExample;

import java.util.concurrent.TimeUnit;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:42
 */
public class AsyncEventDispatchExample {
    static class AsyncInputEventHanlder extends AsyncChannel {
        private final AsyncEventDispatcher dispatcher;

        AsyncInputEventHanlder(AsyncEventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        @Override
        protected void handle(Event message) {
            EventDispatcherExample.InputEvent inputEvent = (EventDispatcherExample.InputEvent) message;
            System.out.printf("X:%d, Y:%d\n", inputEvent.getX(), inputEvent.getY());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int result = inputEvent.getX() + inputEvent.getY();
            dispatcher.dispatch(new EventDispatcherExample.ResultEvent(result));
        }
    }

    static class AsyncResultEventHandler extends AsyncChannel {

        @Override
        protected void handle(Event message) {
            EventDispatcherExample.ResultEvent resultEvent = (EventDispatcherExample.ResultEvent) message;
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The result is: " + resultEvent.getResult());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AsyncEventDispatcher dispatcher = new AsyncEventDispatcher();
        dispatcher.registerChannel(EventDispatcherExample.InputEvent.class, new AsyncInputEventHanlder(dispatcher));
        dispatcher.registerChannel(EventDispatcherExample.ResultEvent.class, new AsyncResultEventHandler());
        dispatcher.dispatch(new EventDispatcherExample.InputEvent(1, 2));
        TimeUnit.SECONDS.sleep(11);
        dispatcher.shutdown();
    }

}
