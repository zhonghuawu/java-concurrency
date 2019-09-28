package com.huaa.java.concurrency.chapter15.cycle;

/**
 * Desc:
 *
 * @author zhonghua.wu
 * @date 2019/7/9 21:17
 */
public class EmptyLifecycle<T> implements TaskLifecycle<T> {

    @Override
    public void onStart(Thread thread) {

    }

    @Override
    public void onRunning(Thread thread) {

    }

    @Override
    public void onFinish(Thread thread, T result) {

    }

    @Override
    public void onError(Thread thread, Exception e) {

    }

}
