package com.huaa.java.concurrency.chapter28.event.bus.directory.monitor;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 0:22
 */
public class FileChangeEvent {
    private final Path path;
    private final WatchEvent.Kind<?> kind;

    public FileChangeEvent(Path path, WatchEvent.Kind<?> kind) {
        this.path = path;
        this.kind = kind;
    }

    public Path getPath() {
        return path;
    }

    public WatchEvent.Kind<?> getKind() {
        return kind;
    }
}
