package com.xc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @ Author     ：xccaia
 * @ Date       ：2019/11/19 21:16
 * @ Description：
 */
@EnableCaching
@SpringBootApplication
public class RedisApplication0706 {

  public static void main(String[] args) {
    SpringApplication.run(RedisApplication0706.class, args);
    System.out.println("111111111");
  }
}
