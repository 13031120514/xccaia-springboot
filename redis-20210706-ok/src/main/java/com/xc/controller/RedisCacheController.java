package com.xc.controller;


import com.xc.entity.User;
import com.xc.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class RedisCacheController {

  private static Map<String, User> map = new HashMap<>();

  static {
    map.put("1", new User("1", "2", "3"));
    map.put("2", new User("2", "2", "3"));
    map.put("3", new User("3", "2", "3"));
  }

  @Autowired
  UserService userService;

  @RequestMapping("/getAll")
  @ResponseBody
  public List<User> getAll() {
    List<User> userList = userService.getAll();
    return userList;
  }

  @RequestMapping("/getOne")
  @ResponseBody
  public User getOne(@RequestParam(value = "id") String id) {
    User user = userService.getOne(id);
    return user;
  }

  @RequestMapping("/clear")
  @ResponseBody
  public String clear() {
    userService.clear();
    return "OK";
  }
}
