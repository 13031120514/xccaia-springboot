package com.xc.controller;


import com.xc.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
@CacheConfig(cacheNames = "test")
public class RedisCacheController {

  private static Map<String, User> map = new HashMap<>();

  static {
    map.put("1", new User("1", "2", "3"));
    map.put("2", new User("2", "2", "3"));
    map.put("3", new User("3", "2", "3"));
  }


  @RequestMapping("/getAll")
  @ResponseBody
  @Cacheable
  public List<User> getAll() {
//    map.put("1", new User("1", "2", "3"));
//    map.put("2", new User("2", "2", "3"));
//    map.put("3", new User("3", "2", "3"));
    List<User> list = new ArrayList<>();
//    for (Map.Entry<String, User>  entry : map) {
//      list.add(entry.getValue());
//    }
    for (String key : map.keySet()) {
      list.add(map.get(key));
    }

    return list;

  }

  @RequestMapping("/getOne")
  @ResponseBody
  @Cacheable(key = "#id")
  public User getOne(@RequestParam(value = "id") String id) {
    User user = map.get(id);
    return user;
  }
}
