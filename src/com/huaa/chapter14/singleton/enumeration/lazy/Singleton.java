package com.huaa.chapter14.singleton.enumeration.lazy;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/10 0:49
 */
public class Singleton {

    private byte[] data = new byte[1024];

    private Singleton() {

    }

    private enum EnumHolder {
        INSTANCE;

        private Singleton instance;

        EnumHolder() {
            this.instance = new Singleton();
        }

        private Singleton getInstance() {
            return instance;
        }

    }

    public static Singleton getInstance() {
        return EnumHolder.INSTANCE.getInstance();
    }

}
