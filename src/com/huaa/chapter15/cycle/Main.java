package com.huaa.chapter15.cycle;

import java.util.concurrent.TimeUnit;

/**
 * Desc:
 *
 * @author zhonghua.wu
 * @date 2019/7/9 22:05
 */
public class Main {

    public static void main(String[] args) {
        test1();
        System.out.println("<<----->>");
        test2();
    }

    private static void test1() {
        Observable observable = new ObservableThread<>(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish done.");
            return null;
        });
        observable.start();
    }

    private static void test2() {
        final TaskLifecycle<String> lifecycle = new EmptyLifecycle<String>() {
            @Override
            public void onFinish(Thread thread, String result) {
                System.out.println("The result is " + result);
            }
        };

        Observable observable = new ObservableThread<>(lifecycle, ()-> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish done.");
            return "Hello Observer";
        });
        observable.start();
    }

}
