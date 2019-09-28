package com.huaa.java.concurrency.chapter29.event.driven.chat;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:57
 */
public class UserOnlineEvent extends UserEvent {
    public UserOnlineEvent(User user) {
        super(user);
    }
}
