package com.huaa.chapter29.event.driven.exception;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:24
 */
public class MessageMatcherException extends RuntimeException {
    public MessageMatcherException(String message) {
        super(message);
    }
}
