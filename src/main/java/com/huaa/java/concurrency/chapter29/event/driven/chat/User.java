package com.huaa.java.concurrency.chapter29.event.driven.chat;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:51
 */
public class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
