package com.huaa.chapter22.balking;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/14 23:43
 */
public class BalkingTest {

    public static void main(String[] args) {
        new DocumentEditThread("D:\\", "balking.txt").start();
    }

}
