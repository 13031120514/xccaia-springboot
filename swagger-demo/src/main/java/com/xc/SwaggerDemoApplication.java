package com.xc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ Author     ：xccaia
 * @ Date       ：2020-03-31
 * @ Description：
 */
@SpringBootApplication
public class SwaggerDemoApplication {

  public static void main(String[] args) {
    System.out.println("访问这个地址来查询接口");
    System.out.println("http://localhost:8801/swagger-ui.html");
    SpringApplication.run(SwaggerDemoApplication.class, args);
    System.out.println("访问这个地址来查询接口");
    System.out.println("http://localhost:8801/swagger-ui.html");
  }
}