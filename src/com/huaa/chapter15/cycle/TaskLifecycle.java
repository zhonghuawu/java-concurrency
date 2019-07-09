package com.huaa.chapter15.cycle;

/**
 * Desc:
 *
 * @author zhonghua.wu
 * @date 2019/7/9 21:15
 */
public interface TaskLifecycle<T> {

    void onStart(Thread thread);

    void onRunning(Thread thread);

    void onFinish(Thread thread, T result);

    void onError(Thread thread, Exception e);

}
