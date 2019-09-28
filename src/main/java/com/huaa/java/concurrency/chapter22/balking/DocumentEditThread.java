package com.huaa.java.concurrency.chapter22.balking;

import java.io.IOException;
import java.util.Scanner;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/14 23:39
 */
public class DocumentEditThread extends Thread {

    private final String path;
    private final String name;

    private final Scanner scanner = new Scanner(System.in);

    public DocumentEditThread(String path, String name) {
        super("DocumentEditThread");
        this.path = path;
        this.name = name;
    }

    @Override
    public void run() {
        final int saveTimes = 5;
        int times = 0;

        try {
            Document document = Document.create(path, name);
            while (true) {
                String text = scanner.next();
                if ("quit".equals(text)) {
                    document.close();
                    break;
                }
                document.edit(text);
                if (times == saveTimes) {
                    document.save();
                    times = 0;
                }
                times++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
