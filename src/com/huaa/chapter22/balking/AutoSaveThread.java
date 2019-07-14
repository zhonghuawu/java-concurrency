package com.huaa.chapter22.balking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/14 23:27
 */
public class AutoSaveThread extends Thread {

    private final Document document;

    public AutoSaveThread(Document document) {
        super("DocumentAutoSaveThread");
        this.document = document;
    }

    @Override
    public void run() {
        while (!document.isClosed()) {
            try {
                document.save();
                TimeUnit.SECONDS.sleep(1);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
