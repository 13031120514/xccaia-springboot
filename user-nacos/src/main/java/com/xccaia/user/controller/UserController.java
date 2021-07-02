package com.xccaia.user.controller;

import com.xccaia.user.mapper.UserMapper;

import com.xccaia.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author     ：xccaia
 * @ Date       ：2021-03-24
 * @ Description： swagger 用户信息处理
 */
@RestController
@Api(value = "UserController : 用户信息处理")
public class UserController {

  final String BASE_URL = "/user";

  @Autowired
  private UserMapper userMapper;

  @PostMapping(value = BASE_URL + "/selectAll")
  @ResponseBody
  @ApiOperation("通用mapper生成sql")
  public List<User> selectAll() {
    return userMapper.selectAll();
  }

  @PostMapping(value = BASE_URL + "/findAll")
  @ResponseBody
  @ApiOperation("用Select注解生成sql")
  public List<User> findAll() {
    return userMapper.findAll();
  }

  @PostMapping(value = BASE_URL + "/queryAll")
  @ResponseBody
  @ApiOperation("手写Sql生成的在xml中")
  public List<User> queryAll() {
    return userMapper.queryAll();
  }


}
