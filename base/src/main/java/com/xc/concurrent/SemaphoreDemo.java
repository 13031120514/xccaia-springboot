package com.xc.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @ Author     ：xccaia
 * @ Date       ：2020-03-09
 * @ Description：Semaphore包含一组许可证
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new DoAnything(i, semaphore).start();
        }

    }

    static class DoAnything extends Thread {
        private final int num;
        private final Semaphore semaphore;

        public DoAnything(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(); // 阻塞获取一个许可证
                System.out.println("第" + num + "个线程进入");
                Thread.sleep(2000);
                semaphore.release();//释放许可证
                System.out.println("第" + num + "释放许可证");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

