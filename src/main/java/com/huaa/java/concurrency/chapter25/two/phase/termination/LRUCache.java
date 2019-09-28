package com.huaa.java.concurrency.chapter25.two.phase.termination;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/17 23:44
 */
public class LRUCache<K, V> {

    private final LinkedList<K> keyList = new LinkedList<>();

    private final Map<K, V> cache = new HashMap<>();

    private final int capacity;

    private final CacheLoader<K, V> cacheLoader;

    public LRUCache(int capacity, CacheLoader cacheLoader) {
        this.capacity = capacity;
        this.cacheLoader = cacheLoader;
    }

    public void put(K key, V value) {
        if (keyList.size() >= capacity) {
            K eldestKey = keyList.removeFirst();
            cache.remove(eldestKey);
        }
        if (keyList.contains(key)) {
            keyList.remove(key);
        }
        keyList.addLast(key);
        cache.put(key, value);
    }

    public V get(K key) {
        V value;
        boolean success = keyList.remove(key);
        if (!success) {
            value = cacheLoader.load(key);
            this.put(key, value);
        } else {
            value = cache.get(key);
            keyList.addLast(key);
        }
        return value;
    }

    @Override
    public String toString() {
        return this.keyList.toString();
    }
}
