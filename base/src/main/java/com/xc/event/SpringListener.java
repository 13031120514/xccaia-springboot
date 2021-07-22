package com.xc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

public class SpringListener implements ApplicationListener<SpringEvent> {


  @Async
  @Override
  public void onApplicationEvent(SpringEvent event) {
    System.out.println(this.getClass() + String.format("收到事件，消息内容为[%s]",event.getMessage()));
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(this.getClass() + "执行了监听");
  }

}