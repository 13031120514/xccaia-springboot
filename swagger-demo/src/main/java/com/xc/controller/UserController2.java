package com.xc.controller;

import io.swagger.annotations.*;
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
@Api(tags = " UserController2  : 说明该类的作用，可以在UI界面上看到的注解",
        value = "UserController2 : 该参数没什么意义，在UI界面上也看到，所以不需要配置",
        description = "UserController2 : 用户信息操作2")
@RequestMapping("/app2")
public class UserController2 {

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/user/{id}")
    public @ResponseBody
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(code = 404, message = "异常错误")
    })
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
