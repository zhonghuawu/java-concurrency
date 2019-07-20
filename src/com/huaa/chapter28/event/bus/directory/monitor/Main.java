package com.huaa.chapter28.event.bus.directory.monitor;

import com.huaa.chapter28.event.bus.AsyncEventBus;
import com.huaa.chapter28.event.bus.EventBus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 0:25
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors() * 2);
        final EventBus eventBus = new AsyncEventBus(executor);

        eventBus.register(new FileChangeListener());
        final String targetPath = "E:\\monitor";
        DirectoryTargetMonitor monitor = new DirectoryTargetMonitor(eventBus, targetPath);
        monitor.startMonitor();
    }

}
