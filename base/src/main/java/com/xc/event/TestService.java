package com.xc.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  @Autowired
  private ApplicationContext applicationContext;

  public void test(String meseage) {
    applicationContext.publishEvent(new SpringEvent(applicationContext, meseage));
    System.out.println("事件发布完了");
  }
}