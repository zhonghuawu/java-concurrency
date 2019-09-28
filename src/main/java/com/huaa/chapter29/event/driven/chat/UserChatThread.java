package com.huaa.chapter29.event.driven.chat;

import com.huaa.chapter29.event.driven.async.AsyncEventDispatcher;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 15:02
 */
public class UserChatThread extends Thread {
    private final User user;
    private final AsyncEventDispatcher dispatcher;


    public UserChatThread(User user, AsyncEventDispatcher dispatcher) {
        super(user.getName());
        this.user = user;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        try {
            dispatcher.dispatch(new UserOnlineEvent(user));
            for (int i = 0; i < 5; i++) {
                dispatcher.dispatch(new UserChatEvent(user, getName() + "-Hello-" + i));
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            dispatcher.dispatch(new UserOfflineEvent(user));
        }
    }

}
