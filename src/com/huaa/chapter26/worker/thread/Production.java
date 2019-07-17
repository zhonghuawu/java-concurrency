package com.huaa.chapter26.worker.thread;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/18 0:19
 */
public class Production extends InstructionBook {

    private final int prodID;

    public Production(int prodID) {
        this.prodID = prodID;
    }

    @Override
    protected void firstProcess() {
        System.out.println("execute the " + prodID + " first process");
    }

    @Override
    protected void secondProcess() {
        System.out.println("execute the " + prodID + " second process");
    }

    @Override
    public String toString() {
        return "Production-" + prodID;
    }
}
