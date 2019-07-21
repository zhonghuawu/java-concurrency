package com.huaa.chapter29.event.driven;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:15
 */
public class Event implements Message {

    @Override
    public Class<? extends Message> getType() {
        return getClass();
    }

}
