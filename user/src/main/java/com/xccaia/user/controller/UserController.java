package com.xccaia.user.controller;

import com.xccaia.user.mapper.UserMapper;

import com.xccaia.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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

  @ApiOperation("3s")
  @PostMapping("/supplier/test111")
  @ResponseBody
  public String test111() {
    int time = 3 * 1000;
    System.out.println("start " + new java.util.Date());
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();

    }
    System.out.println("end " + new java.util.Date());
    return "111111111";
  }

  @ApiOperation("1s")
  @PostMapping("/supplier/test1112")
  @ResponseBody
  public String test1112() {
    int time = 1 * 1000;
    System.out.println("start " + new java.util.Date());
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();

    }
    System.out.println("end " + new java.util.Date());
    return "111111111";
  }

  @ApiOperation("设置时间")
  @PostMapping("/supplier/test1111112")
  @ResponseBody
  public String test1111112(int time) {
    time = time * 1000;
    System.out.println("start " + new java.util.Date());
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("end " + new java.util.Date());
    return "111111111";
  }


  /**
   * Post提交字符串 使用Post方法发送一串字符串，但不建议发送超过1M的文本信息
   */
  @ApiOperation("Post提交字符串")
  @PostMapping("/supplier/1111")
  @ResponseBody
  public void postStringParameters() {
    MediaType MEDIA_TYPE = MediaType.parse("text/text; charset=utf-8");
    String url = "http://v.juhe.cn/wepiao/query"; // 请求链接
    OkHttpClient okHttpClient = new OkHttpClient(); // OkHttpClient对象
    String string = "key=9488373060c8483a3ef6333353fdc7fe"; // 要发送的字符串
    /**
     * RequestBody.create(MEDIA_TYPE, string)
     * 第二个参数可以分别为：byte[]，byteString,File,String。
     */
    Request request = new Request.Builder().url(url)
        .post(RequestBody.create(MEDIA_TYPE, string)).build();
    okHttpClient.newCall(request).enqueue(new Callback() {
      public void onResponse(Call call, Response response) throws IOException {
        System.out.println(response.body().string());
      }

      public void onFailure(Call call, IOException e) {
        System.out.println(e.getMessage());
      }
    });
  }


  /**
   * 同步get请求
   */
  @ApiOperation("同步get请求")
  @PostMapping("/supplier/2222")
  @ResponseBody
  public void syncGet() throws Exception {
    String urlBaidu = "http://www.baidu.com/";
    OkHttpClient okHttpClient = new OkHttpClient(); // 创建OkHttpClient对象
    Request request = new Request.Builder().url(urlBaidu).build(); // 创建一个请求
    Response response = okHttpClient.newCall(request).execute(); // 返回实体
    if (response.isSuccessful()) { // 判断是否成功
      /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
       * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
       * 因为string() 方法会将整个文档加载到内存中。*/

      int time = 5 * 1000;
      System.out.println("start " + new java.util.Date());
      try {
        Thread.sleep(time);
      } catch (InterruptedException e) {
        e.printStackTrace();

      }

      System.out.println(response.body().string()); // 打印数据
    } else {
      System.out.println("失败"); // 链接失败
    }
  }
}
