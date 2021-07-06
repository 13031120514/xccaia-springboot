package com.xc.controller;


import com.xc.entity.User;
import com.xc.service.IUserService;
import com.xc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user2")
@Api(description = "用户操作-接口方式")
public class RedisCacheController2 {

  @Autowired
  IUserService userService;

  @RequestMapping(value = "/getAll", method = RequestMethod.POST)
  @ResponseBody
  @ApiOperation(value = "获取所有用户详细信息", notes = "获取所有用户详细信息")
  public List<User> getAll() {
    List<User> userList = userService.getAll();
    return userList;
  }

  @RequestMapping(value = "/getOne", method = RequestMethod.POST)
  @ResponseBody
  @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
  public User getOne(@RequestParam(value = "id") String id) {
    User user = userService.getOne(id);
    return user;
  }

  @RequestMapping(value = "/clear", method = RequestMethod.POST)
  @ResponseBody
  @ApiOperation(value = "清空缓存", notes = "清空缓存")
  public String clear() {
    userService.clear();
    return "OK";
  }
}
