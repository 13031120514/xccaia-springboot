package com.xc;

import com.xc.event.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {


  @Autowired

  static TestService testService;

  public static void main(String[] args) {
    SpringApplication.run(MyApplication.class, args);
//    testService.test("1111111111111111111");
    new TestService().test("222222222");

  }
}
