package com.xc.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * @ Author     ：xccaia
 * @ Date       ：2019/11/25 21:37
 * @ Description：线程之间循环调用 实现A->B->C
 * 三个线程实现AA打印2次，BB打印3次，CC打印 5次
 */

class ShareData {

    private int num = 1;// AA:1,BB:2,CC:3
    private final Lock lock = new ReentrantLock();
    // 创建3把钥匙
    private final Condition cd1 = lock.newCondition();
    private final Condition cd2 = lock.newCondition();
    private final Condition cd3 = lock.newCondition();

    public void print2(int total) {
        lock.lock();
        try {
            // 判断
            while (num != 1) {
                cd1.await();
            }
            // 干活
            for (int i = 1; i <= 2; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + total + " \t" + i);
            }
            // 通知
            num = 2;
            cd2.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void print3(int total) {
        lock.lock();
        try {
            // 判断
            while (num != 2)
                cd2.await();
            // 干活
            for (int i = 1; i <= 3; i++)
                System.out.println(Thread.currentThread().getName() + "\t " + total + " \t" + i);
            // 通知
            num = 3;
            cd3.signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void print5(int total) {
        lock.lock();
        try {
            // 判断
            while (num != 3) {
                cd3.await();
            }
            // 干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + total + " \t" + i);
            }
            // 通知
            num = 1;
            cd1.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

}


public class ThreadOrderAccess {


    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                shareData.print2(i);
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                shareData.print3(i);

            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                shareData.print5(i);
            }
        }, "CC").start();

//
//        new Thread(()-> {
//           new St
//        },"CC").start();

    }

}
