package com.huaa.java.concurrency.chapter29.event.driven;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:12
 */
public interface Channel<E extends Message> {

    /**
     * dispatch 负责Message的调度
     */
    void dispatch(E message);

}
