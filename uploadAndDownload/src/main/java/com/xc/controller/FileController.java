package com.xc.controller;

import com.xc.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @author : xiaochuan.cai
 * @date : 2019/11/26
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private ImportService importService;

    //传统springmvc上传方式 需要使用spring mvc 的jar
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
//    public String getfile(@RequestParam("myfile") MultipartFile file) {
    public String getfile(@RequestParam("myfile") MultipartFile file, @ModelAttribute User user) {
//    public String getfile(@RequestParam("myfile") MultipartFile file, @RequestParam("name") String name) {
        System.out.println("file name = " + file.getOriginalFilename());
//        System.out.println("name: " + name);
        System.out.println("name: " + user.getName());
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传的路径
        String filePath = "C:\\A_Data\\";
        // fileName处理
        fileName = filePath + UUID.randomUUID() + fileName;
        // 文件对象
        File dest = new File(fileName);
        // 创建路径
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            //保存文件
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }


    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws FileNotFoundException {
//        File file =new File("E:\\A_Data\\Delphine Mantoulet - Java.mp3");
        File file = new File("D:\\A_Data\\data.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 设置被下载而不是被打开
        response.setContentType("application/gorce-download");
        // Content-disposition其实可以控制用户请求所得的内容存为一个文件的时候提供一个默认的文件名，文件直接在浏览器上显示或者在访问时弹出文件下载对话框。
//        response.addHeader("Content-disposition","attachment;fileName=Delphine Mantoulet - Java.mp3");
        response.addHeader("Content-disposition", "attachment;fileName=data.txt");
        try {
            OutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/uploadExcel")
    @ResponseBody
    public String uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("myfile");
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();

        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            System.out.println(lo);
        }
//
        return "上传成功";
    }

}

//        }