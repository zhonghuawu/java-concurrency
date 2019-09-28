package com.huaa.java.concurrency.chapter16.thread.safe;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/13 16:43
 */
public class TablewarePair {

    private final Tableware leftTool;
    private final Tableware rightTool;

    public TablewarePair(Tableware leftTool, Tableware rightTool) {
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    public Tableware getLeftTool() {
        return leftTool;
    }

    public Tableware getRightTool() {
        return rightTool;
    }
}
