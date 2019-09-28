package com.huaa.chapter29.event.driven;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:13
 */
public interface DynamicRouter<E extends Message> {

    /**
     * 注册channel
     */
    void registerChannel(Class<? extends E> messageType, Channel<? extends E> channel);

    /**
     * 为相应的channel分配message
     */
    void dispatch(E message);

}
