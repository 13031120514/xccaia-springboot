package com.xc.atomic;

/**
 * 解决 Atomic的ABA的问题,加了一个版本号
 */
public class AtomicStampedReferenceTest {

  public static void main(String[] args) {
    System.out.println(1);
  }
}
