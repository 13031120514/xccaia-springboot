package com.xc;

import org.junit.Test;
import org.junit.Before;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：xccaia
 * @ Date       ：2020-03-09
 * @ Description：
 */
public class RedissonClientDemo {

  RedissonClient redissonClient = null;

  @Before
  public void setup() {
    Config config = new Config();
    config.useSingleServer().setAddress("redis://127.0.0.1:6379");
    redissonClient = Redisson.create(config);
  }

  @Test
  public void xc() {
    System.out.println(111);

  }


  @Test
  public void test1() {

    redissonClient.getBucket("xccaia").set("xccaia");
    String reuslt = (String) redissonClient.getBucket("xccaia").get();
    System.out.println(reuslt);
  }


  @Test
  public void RedissonLock() {
    RLock rLock = redissonClient.getLock("updateOrder");
    try {
      rLock.tryLock(100, 10, TimeUnit.SECONDS);
      System.out.println("test");
      Thread.sleep(1000);
      rLock.unlock();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      rLock.unlock();
//            redissonClient.shutdown();
    }

  }


}
