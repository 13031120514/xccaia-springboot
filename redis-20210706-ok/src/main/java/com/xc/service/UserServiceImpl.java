package com.xc.service;

import com.xc.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "test:user2")
public class UserServiceImpl implements IUserService {


  private static Map<String, User> map = new HashMap<>();

  static {
    map.put("1", new User("1", "2", "3"));
    map.put("2", new User("2", "2", "3"));
    map.put("3", new User("3", "2", "3"));
  }

  @Cacheable
  public List<User> getAll() {
    List<User> list = new ArrayList<>();
    for (String key : map.keySet()) {
      list.add(map.get(key));
    }
    return list;

  }

  @Cacheable(key = "#id")
  public User getOne(String id) {
    User user = map.get(id);
    return user;
  }

  @CacheEvict(allEntries = true)
  public void clear() {
  }


}
