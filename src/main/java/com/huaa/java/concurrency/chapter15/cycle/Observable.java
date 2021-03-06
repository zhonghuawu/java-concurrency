package com.huaa.java.concurrency.chapter15.cycle;

/**
 * Desc:
 *
 * @author zhonghua.wu
 * @date 2019/7/9 21:13
 */
public interface Observable {
    enum Cycle {
        /**
         * cycle status
         */
        STARTED,
        RUNNING,
        DONE,
        ERROR
    }

    Cycle getCycle();

    void start();

    void interrupt();

}
