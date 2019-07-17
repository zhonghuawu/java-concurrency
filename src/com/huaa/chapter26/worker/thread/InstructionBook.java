package com.huaa.chapter26.worker.thread;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/18 0:16
 */
public abstract class InstructionBook {

    public final void create() {
        this.firstProcess();
        this.secondProcess();
    }

    protected abstract void firstProcess();
    protected abstract void secondProcess();
}
