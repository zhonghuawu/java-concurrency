package com.huaa.java.concurrency.chapter28.event.bus;

/**
 * Desc: Bus接口定义EventBus的所有使用方法
 *
 * @author wu_zh
 * @date 2019/7/20 10:34
 */
public interface Bus {

    /**
     * 将某个对象注册到Bus上
     *
     * @param subscriber
     */
    void register(Object subscriber);

    /**
     * 将某个对象从Bus上取消注册
     *
     * @param subscriber
     */
    void unregister(Object subscriber);

    /**
     * 提交Event到默认topic
     *
     * @param event
     */
    void post(Object event);

    /**
     * 提交event到指定的topic
     *
     * @param event
     * @param topic
     */
    void post(Object event, String topic);

    /**
     * 关闭Bus
     */
    void close();

    /**
     * 返回Bus的名称标识
     *
     * @return
     */
    String getBusName();

}
