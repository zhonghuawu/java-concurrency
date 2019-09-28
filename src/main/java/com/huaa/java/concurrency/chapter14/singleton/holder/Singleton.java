package com.huaa.java.concurrency.chapter14.singleton.holder;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/10 0:43
 */
public class Singleton {

    private byte[] data = new byte[1024];

    private Singleton() {

    }

    private static class Holder {
        private static Singleton instance = new Singleton();
    }

    /**
     * best ways so far
     */
    public static Singleton getInstance() {
        return Holder.instance;
    }

}
