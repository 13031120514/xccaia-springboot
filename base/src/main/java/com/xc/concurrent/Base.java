package com.xc.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ Author     ：xccaia
 * @ Date       ：2019/11/25 20:16
 * @ Description：
 */
public class Base {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        FutureTask ft=new FutureTask(()->{
            System.out.println("Callable.call()");
            return "ok";
        });

        new Thread(ft,"xccaia").start();
//        ft.get();
        System.out.println(ft.get());

    }

}
