package com.xc;

public class DeletedTest {


  public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {
      if (i == 5) {
        break;
      }
      System.out.println(i);
    }
    System.out.println("1111111111");

    for (int i = 0; i < 10; i++) {

      for (int j = 0; j < 2; j++) {
        if (i == 5) {
          break;
        }
        System.out.println("i=" + i + " j=" + j);
      }
//      System.out.println(i);
    }

  }


}
