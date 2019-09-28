package com.huaa.chapter17.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/14 22:27
 */
public class ShareData {
    private final List<Character> container = new ArrayList<>();

    private final ReadWriteLock readWriteLock = ReadWriteLock.readWriteLock();

    private final Lock readLock = readWriteLock.readLock();

    private final Lock writeLock = readWriteLock.writeLock();

    private final int length;

    public ShareData(int length) {
        this.length = length;
        IntStream.range(0, length).forEach(i -> container.add(i, 'c'));
    }

    public char[] read() throws InterruptedException {
        try {
            readLock.lock();
            char[] newBuffer = new char[length];
            IntStream.range(0, length).forEach(i -> newBuffer[i] = container.get(i));
            slowly();
            return newBuffer;
        } finally {
            readLock.unlock();
        }
    }

    public void write(char c) throws InterruptedException {
        try {
            writeLock.lock();
            IntStream.range(0, length).forEach(i -> this.container.add(i, c));
            slowly();
        } finally {
            writeLock.unlock();
        }
    }

    private void slowly() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
