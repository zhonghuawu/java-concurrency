package com.huaa.chapter5;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Desc:
 *
 * @author zhonghua.wu
 * @date 2019/6/29 14:37
 */
public class BooleanLockTest {

    private final Lock lock = new BooleanLock();

    public void syncMethod() {
        try {
            lock.lock();
            int randomInt = ThreadLocalRandom.current().nextInt(10);
            System.out.println(Thread.currentThread() + " get the lock");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BooleanLockTest blt = new BooleanLockTest();
        IntStream.range(0, 10)
                .mapToObj(i -> new Thread(blt::syncMethod))
                .forEach(Thread::start);
    }

}
