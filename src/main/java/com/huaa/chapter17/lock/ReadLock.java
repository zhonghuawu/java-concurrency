package com.huaa.chapter17.lock;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/13 17:09
 */
public class ReadLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMutex()) {
            while (readWriteLock.getWaitingWriters() > 0
                    || (readWriteLock.getPreferWriter() && readWriteLock.getWaitingWriters() > 0)) {
                readWriteLock.getMutex().wait();
            }
            readWriteLock.incrementReadingReaders();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMutex()) {
            readWriteLock.decrementReadingReaders();
            readWriteLock.changePrefer(true);
            readWriteLock.getMutex().notifyAll();
        }
    }
}
