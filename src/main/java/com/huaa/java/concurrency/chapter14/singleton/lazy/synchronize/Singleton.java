package com.huaa.java.concurrency.chapter14.singleton.lazy.synchronize;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/10 0:36
 */
public class Singleton {

    private byte[] data = new byte[1024];

    private static Singleton instance = null;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }

}
