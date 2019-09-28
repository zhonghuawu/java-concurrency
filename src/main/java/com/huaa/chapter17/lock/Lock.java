package com.huaa.chapter17.lock;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/13 16:49
 */
public interface Lock {

    void lock() throws InterruptedException;

    void unlock();

}
