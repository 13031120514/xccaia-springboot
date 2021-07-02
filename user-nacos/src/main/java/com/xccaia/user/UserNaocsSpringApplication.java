package com.xccaia.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ Author     ：xccaia
 * @ Date       ：2021-03-24
 * @ Description： swagger 用户信息入口启动类
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UserNaocsSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserNaocsSpringApplication.class, args);
  }

}
