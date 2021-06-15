package com.xc.spring.processor;

import java.lang.reflect.InvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MyBeanPostProcessor implements BeanPostProcessor {

  // 前置处理器
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    Class beanClass = bean.getClass();
    if (beanClass == ISomeService.class) {
      System.out.println("bean 对象初始化之前······");
    }
    return bean;
  }

  // 后置处理器 --- 此处具体的实现用的是Java中的动态代理
  public Object postProcessAfterInitialization(final Object beanInstance, String beanName) throws BeansException {
    // 为当前 bean 对象注册监控代理对象，负责增强 bean 对象方法的能力
    Class beanClass = beanInstance.getClass();
    if (beanClass == ISomeService.class) {
      Object proxy = Proxy
          .newProxyInstance(beanInstance.getClass().getClassLoader(), beanInstance.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
              System.out.println("ISomeService 中的 doSome() 被拦截了···");
              String result = (String) method.invoke(beanInstance, args);
              return result.toUpperCase();
            }
          });
      return proxy;
    }
    return beanInstance;
  }
}
