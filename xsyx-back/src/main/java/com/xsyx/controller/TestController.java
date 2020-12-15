package com.xsyx.controller;

import com.xsyx.dao.RoleDao;
import com.xsyx.vo.Role;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RoleDao roleDao;

    /**
     * 测试
     */
    @RequestMapping("/test1")
    public Map<String,String> test1() {
        Map<String,String> map = new HashMap<>();
        map.put("title","标题");
        return map;
    }

    /**
     * 测试2
     */
    @RequestMapping("/test2")
    public List<Role> test2() {
        List<Role> roles = roleDao.queryAll();
        return roles;
    }

    /**
     * 测试文件上传
     */
    @RequestMapping("/fileUpload")
    public Message fileUpload(@RequestParam("img") MultipartFile file, HttpServletRequest request) {
        String filename = file.getContentType();
        System.out.println(filename);
        System.out.println(file.getOriginalFilename());
        System.out.println(request.getServletContext().getRealPath("/src/main/images"));
        /*filename = java.util.UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf('.'));
        //获取项目当前运行的路径     上下文对象
        String path = request.getServletContext().getRealPath("/images");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //将文件保存到该路径下
        try {
            imageFile.transferTo(new File(path, filename));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return new Message(true,"上传成功!");
    }

}
