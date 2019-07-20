package com.huaa.chapter28.event.bus;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/20 12:21
 */
public class SimpleObject {

    @Subscribe(topic = "alex-topic")
    public void test2(Integer x) {

    }

    @Subscribe(topic = "test-topic")
    public void test3(Integer x) {

    }

}
