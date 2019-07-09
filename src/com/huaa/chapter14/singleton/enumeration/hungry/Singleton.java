package com.huaa.chapter14.singleton.enumeration.hungry;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/10 0:46
 */
public enum Singleton {

    INSTANCE;

    private byte[] data = new byte[1024];

    Singleton() {
        System.out.println("INSTANCE will be initialized immediately");
    }

    public static void method() {

    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

}
