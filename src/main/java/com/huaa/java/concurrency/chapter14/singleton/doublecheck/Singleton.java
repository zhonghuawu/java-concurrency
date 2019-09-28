package com.huaa.java.concurrency.chapter14.singleton.doublecheck;

import java.net.Socket;
import java.sql.Connection;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/10 0:39
 */
public class Singleton {

    private byte[] data = new byte[1024];

    private static Singleton instance = null;

    Connection conn;

    Socket socket;

    private Singleton() {
        this.conn = null;// FIXME: 2019/7/10 init connection
        this.socket = null;// FIXME: 2019/7/10 init socket
    }

    /**
     * jvm 指令重排可能会导致线程不安全
     * fixed: instance volatile关键字修饰
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
