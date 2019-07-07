package com.huaa.chapter5;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Desc:
 *
 * @author zhonghua.wu
 * @date 2019/6/29 13:40
 */
public interface Lock {
    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThreads();
}
