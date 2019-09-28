package com.huaa.chapter17.lock;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/13 16:54
 */
public interface ReadWriteLock {

    Lock readLock();

    Lock writeLock();

    int getWritingWriters();

    int getWaitingWriters();

    int getReadingReaders();

    static ReadWriteLock readWriteLock() {
        return new ReadWriteLockImpl();
    }

    static ReadWriteLock readWriteLock(boolean preferWriter) {
        return new ReadWriteLockImpl(preferWriter);
    }

}
