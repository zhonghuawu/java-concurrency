package com.huaa.java.concurrency.chapter28.event.bus.directory.monitor;

import com.huaa.java.concurrency.chapter28.event.bus.Subscribe;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 0:24
 */
public class FileChangeListener {

    @Subscribe
    public void onChange(FileChangeEvent event) {
        System.out.printf("%s-%s\n", event.getPath(), event.getKind());
    }

}
