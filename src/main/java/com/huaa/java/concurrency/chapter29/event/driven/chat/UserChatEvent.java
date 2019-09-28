package com.huaa.java.concurrency.chapter29.event.driven.chat;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:58
 */
public class UserChatEvent extends UserEvent {

    private final String message;

    public UserChatEvent(User user, String message) {
        super(user);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
