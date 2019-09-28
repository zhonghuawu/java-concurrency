package com.huaa.chapter22.balking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/14 23:28
 */
public class Document {

    private boolean changed = false;

    private boolean closed = false;

    private List<String> content = new ArrayList<>();

    private final FileWriter writer;

    private static AutoSaveThread autoSaveThread;

    private Document(String documentPath, String documentName) throws IOException {
        this.writer = new FileWriter(new File(documentPath, documentName));
    }

    public static Document create(String path, String name) throws IOException {
        Document document = new Document(path, name);
        autoSaveThread = new AutoSaveThread(document);
        autoSaveThread.start();
        return document;
    }

    public void edit(String content) {
        synchronized (this) {
            this.content.add(content);
            this.changed = true;
        }
    }

    public void close() throws IOException {
        autoSaveThread.interrupt();
        writer.close();
        this.closed = true;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void save() throws IOException {
        synchronized (this) {
            if (!changed) {
                return;
            }
            System.out.println(Thread.currentThread() + " execute the save action");
            for (String cacheLine : content) {
                this.writer.write(cacheLine);
                this.writer.write(System.lineSeparator());
            }
            this.writer.flush();
            this.changed = false;
            this.content.clear();
        }
    }

}
