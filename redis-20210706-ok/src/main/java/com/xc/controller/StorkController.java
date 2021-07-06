package com.xc.controller;


import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/stock")
public class StorkController {


  @Autowired
  private StringRedisTemplate stringRedisTemplate;
  String key = "stock";

  /**
   * http://localhost:8080/stock/reduceStock1
   */
  @RequestMapping("/reduceStock1")
  @ResponseBody
  public synchronized String reduceStock1() {
    try {
      // 查库存
      String strStock = stringRedisTemplate.opsForValue().get(key);
      int stock = Integer.parseInt(strStock);
      if (stock > 0) {
        stringRedisTemplate.opsForValue().set(key, String.valueOf(stock - 1));
        System.out.println("扣减成功，剩余库存" + (stock - 1));
        return "扣减成功，剩余库存" + (stock - 1);
      } else {
        System.out.println("扣减失败，库存不去");
        return "扣减失败，库存不去";
      }
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
    return "finish";
  }

  @RequestMapping("/reduceStock2")
  @ResponseBody
  public synchronized String reduceStock2() {
    try {
      Long num = stringRedisTemplate.opsForValue().increment("lock", 0);
      stringRedisTemplate.expire("lock", 10, TimeUnit.SECONDS);
      // 查库存
      String strStock = stringRedisTemplate.opsForValue().get(key);
      int stock = Integer.parseInt(strStock);
      if (stock > 0) {
        stringRedisTemplate.opsForValue().set(key, String.valueOf(stock - 1));
        System.out.println("扣减成功，剩余库存" + (stock - 1));
        return "扣减成功，剩余库存" + (stock - 1);
      } else {
        System.out.println("扣减失败，库存不去");
        return "扣减失败，库存不去";
      }
    } catch (NumberFormatException e) {
      e.printStackTrace();
    } finally {
      stringRedisTemplate.delete("lock");
    }
    return "finish";
  }


  @RequestMapping("/setstock")
  @ResponseBody
  public String set() {
    try {
      // 查库存
      stringRedisTemplate.opsForValue().set(key, "100");
      return "重置成功";
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
    return "finish";
  }
}
