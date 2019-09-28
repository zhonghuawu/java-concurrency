package com.huaa.java.concurrency.chapter15.cycle;

/**
 * Desc:
 *
 * @author zhonghua.wu
 * @date 2019/7/9 21:24
 */
public interface Task<T> {

    T call();

}
