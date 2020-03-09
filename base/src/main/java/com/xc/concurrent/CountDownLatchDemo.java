package com.xc.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @ Author     ：xccaia
 * @ Date       ：2020-03-09
 * @ Description：
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            try {
                Thread.sleep(2000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();  //递减

        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();

        }).start();

        new Thread(() -> {
            countDownLatch.countDown();
            try {
                Thread.sleep(2000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        countDownLatch.await(); //阻塞
        System.out.println("执行完毕 ");
    }
}
