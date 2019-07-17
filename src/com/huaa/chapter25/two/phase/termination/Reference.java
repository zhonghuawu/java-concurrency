package com.huaa.chapter25.two.phase.termination;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/17 23:54
 */
public class Reference {
    private final byte[] data = new byte[2 << 19];

    protected void finalize() throws Throwable {
        System.out.println("the reference will be GC.");
    }
}
