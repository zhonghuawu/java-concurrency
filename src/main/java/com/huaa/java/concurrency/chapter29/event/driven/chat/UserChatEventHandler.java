package com.huaa.java.concurrency.chapter29.event.driven.chat;

import com.huaa.java.concurrency.chapter29.event.driven.Event;
import com.huaa.java.concurrency.chapter29.event.driven.async.AsyncChannel;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 15:01
 */
public class UserChatEventHandler extends AsyncChannel {
    @Override
    protected void handle(Event message) {
        UserChatEvent event = (UserChatEvent) message;
        System.out.println("The User[" + event.getUser().getName() + "] say: " + event.getMessage());
    }
}
