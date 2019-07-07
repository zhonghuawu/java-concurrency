package com.huaa.chapter9;

/**
 * Desc:
 *
 * @author huaa
 * @date 7/7/19 4:57 PM
 */
public class Singleton {

    private static int x = 0;
    private static int y;
    private static Singleton instance = new Singleton();


    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.x);
        System.out.println(Singleton.y);
    }

}
