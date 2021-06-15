package com.xc.spring.processor;

import org.springframework.stereotype.Service;

@Service
public class ISomeService implements BaseService {
​

  public String doSomething() {
    // 增强效果：返回内容全部大写
    return "Hello i am kxm";
  }

  public String eat() {
    return "eat food";
  }
}
