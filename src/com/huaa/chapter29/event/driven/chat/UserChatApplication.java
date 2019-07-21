package com.huaa.chapter29.event.driven.chat;

import com.huaa.chapter29.event.driven.async.AsyncEventDispatcher;

import java.util.concurrent.TimeUnit;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 15:05
 */
public class UserChatApplication {

    public static void main(String[] args) throws InterruptedException {
        final AsyncEventDispatcher dispatcher = new AsyncEventDispatcher();
        dispatcher.registerChannel(UserOnlineEvent.class, new UserOnlineEvenChannel());
        dispatcher.registerChannel(UserOfflineEvent.class, new UserOfflineEventChannel());
        dispatcher.registerChannel(UserChatEvent.class, new UserChatEventHandler());

        new UserChatThread(new User("Leo"), dispatcher).start();
        new UserChatThread(new User("Alex"), dispatcher).start();
        new UserChatThread(new User("Collin"), dispatcher).start();

        TimeUnit.MINUTES.sleep(1);
        dispatcher.shutdown();
    }

}
