package com.sgcc.eip.cmc.cable.biz.acquisition.dto.msg;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite {

  public static void main(String[] args) {
    CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    System.out.println("主线程-0:" + list.toString());
    new Thread(() -> {
      System.out.println("读子线程-0:" + list.toString());
    }).start();
    new Thread(() -> {
      list.add("d");
      System.out.println("写子线程-0:" + list.toString());
    }).start();
    new Thread(() -> {
      System.out.println("读子线程-1:" + list.toString());
    }).start();
    list.add("e");
    new Thread(() -> {
      System.out.println("读子线程-2:" + list.toString());
    }).start();
    System.out.println("主线程-1:" + list.toString());
    new Thread(() -> {
      list.add("f");
      System.out.println("写子线程-1:" + list.toString());
    }).start();
    System.out.println("主线程-2:" + list.toString());
    new Thread(() -> {
      System.out.println("读子线程-3:" + list.toString());
    }).start();

  }
}
