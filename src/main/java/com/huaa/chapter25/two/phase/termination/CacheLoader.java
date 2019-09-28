package com.huaa.chapter25.two.phase.termination;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/17 23:47
 */
@FunctionalInterface
public interface CacheLoader<K, V> {
    /**
     * load value by key
     *
     * @param k
     * @return
     */
    V load(K k);
}
