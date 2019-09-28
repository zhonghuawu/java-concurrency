package com.huaa.chapter29.event.driven.chat;

import com.huaa.chapter29.event.driven.Event;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:55
 */
class UserEvent extends Event {
    private final User user;

    public UserEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
