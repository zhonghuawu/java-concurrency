package com.huaa.chapter14.singleton.lazy;

public class Singleton {

    private byte[] data = new byte[1024];

    private static Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }

}
