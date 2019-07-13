package com.huaa.chapter16.thread.safe;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/13 16:31
 */
class EatNoodleThread extends Thread {

    private final String name;

    private final TablewarePair tablewarePair;

    public EatNoodleThread(String name, TablewarePair tablewarePair) {
        this.name = name;
        this.tablewarePair = tablewarePair;
    }

    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }

    private void eat() {
        synchronized (tablewarePair) {
            System.out.println(name + " take up " + tablewarePair.getLeftTool() + "(left)");
            System.out.println(name + " take up " + tablewarePair.getRightTool() + "(right)");
            System.out.println(name + " is eating now.");
            System.out.println(name + " put down " + tablewarePair.getRightTool() + "(right)");
            System.out.println(name + " put down " + tablewarePair.getLeftTool() + "(left)");
        }
    }

    public static void main(String[] args) {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        TablewarePair tablewarePair = new TablewarePair(fork, knife);
        new EatNoodleThread("A", tablewarePair).start();
        new EatNoodleThread("B", tablewarePair).start();
    }

}
