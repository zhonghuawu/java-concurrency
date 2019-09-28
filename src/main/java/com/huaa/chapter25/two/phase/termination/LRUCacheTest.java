package com.huaa.chapter25.two.phase.termination;

import java.util.concurrent.TimeUnit;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/17 23:53
 */
public class LRUCacheTest {

    public static void main(String[] args) throws InterruptedException {
        test2();
    }

    private static void test2() throws InterruptedException {
        LRUCache<Integer, Reference> cache = new LRUCache<>(200, key -> new Reference());
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            cache.get(i);
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("The " + i + " reference stored at cache.");
        }
    }

    private static void test1() {
        LRUCache<String, Reference> cache = new LRUCache<>(5, key -> new Reference());
        cache.get("a");
        cache.get("b");
        cache.get("c");
        cache.get("d");
        cache.get("e");

        cache.get("f");
        cache.get("b");
        cache.get("c");
        cache.get("b");
        System.out.println(cache.toString());
    }
}
