package com.huaa.java.concurrency.chapter10;

/**
 * Desc:
 *
 * @author huaa
 * @date 7/7/19 5:02 PM
 */
public class BootstrapClassLoader {

    public static void main(String[] args) {
        System.out.println("Bootstrap: " + String.class.getClassLoader());
        System.getProperties().list(System.out);

        try {
            Class<?> cls = Class.forName("com.huaa.java.concurrency.chapter10.BootstrapClassLoader");
            System.out.println(cls.getClassLoader());
            System.out.println(cls.getClassLoader().getParent());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
