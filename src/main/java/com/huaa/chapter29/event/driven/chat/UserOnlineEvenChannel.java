package com.huaa.chapter29.event.driven.chat;

import com.huaa.chapter29.event.driven.Event;
import com.huaa.chapter29.event.driven.async.AsyncChannel;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:59
 */
public class UserOnlineEvenChannel extends AsyncChannel {
    @Override
    protected void handle(Event message) {
        UserOnlineEvent event = (UserOnlineEvent) message;
        System.out.println("The User[" + event.getUser().getName() + "] is online.");
    }
}
