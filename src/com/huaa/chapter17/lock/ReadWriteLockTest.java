package com.huaa.chapter17.lock;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/14 22:35
 */
public class ReadWriteLockTest {

    private final static String text = "Thisistheexampleforreadwritelock";

    public static void main(String[] args) {
        final ShareData shareData = new ShareData(50);
        final int writeNum = 2;
        for (int i = 0; i < writeNum; i++) {
            new Thread(() -> {
                for (int index = 0; index < text.length(); index++) {
                    try {
                        char c = text.charAt(index);
                        shareData.write(c);
                        System.out.println(Thread.currentThread() + " write " + c);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        final int readNum = 10;
        for (int i = 0; i < readNum; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread() + " read " + new String(shareData.read()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

}
