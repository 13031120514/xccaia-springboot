package com.xc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：xccaia
 * @ Date       ：2020-03-31
 * @ Description：
 */
@RestController
@Api(description = "用户信息操作")
public class UserController {

  @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
  @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
  @GetMapping("/user/{id}")
  public @ResponseBody
  User getUserById(@PathVariable("id") Integer id) {

    return new User(10001, "测试用户");
  }


  @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
  @ApiImplicitParams(
      {@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path"),
          @ApiImplicitParam(name = "userName", value = "用户名称", required = false, dataType = "String", paramType = "query"),
          @ApiImplicitParam(name = "remark", value = "备注", required = false, dataType = "String", paramType = "query")
      }
  )
  @GetMapping("/user2/{id}")
  public @ResponseBody
  List<User> getUser(@PathVariable("id") Integer id, String userName, String remark) {

    User user = new User(id, userName, remark);
    User user2 = new User(id, userName, remark);
    List list = new ArrayList();
    list.add(user);
    user.setRemark(user.getRemark() + "  : append 1234567");
    list.add(user2);
    user = user2;
    list.add(user);

    return list;
  }

  @ApiOperation(value = "保存用户详细信息", notes = "保存用户详细信息")
  @PostMapping("/save")
  public User save(@RequestBody User user) {
    return user;
  }
}
