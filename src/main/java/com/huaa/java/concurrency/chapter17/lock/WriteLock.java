package com.huaa.java.concurrency.chapter17.lock;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/13 17:12
 */
public class WriteLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMutex()) {
            try {
                readWriteLock.incrementWaitingWriters();
                while (readWriteLock.getReadingReaders() > 0 || readWriteLock.getWritingWriters() > 0) {
                    readWriteLock.getMutex().wait();
                }
            } finally {
                this.readWriteLock.decrementWaitingWriters();
            }
            readWriteLock.incrementWritingWriters();
        }

    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMutex()) {
            readWriteLock.decrementWritingWriters();
            readWriteLock.changePrefer(false);
            readWriteLock.getMutex().notifyAll();
        }

    }
}
