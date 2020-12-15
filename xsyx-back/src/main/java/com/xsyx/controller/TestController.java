package com.xsyx.controller;

import com.xsyx.dao.RoleDao;
import com.xsyx.vo.Role;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    public Message fileUpload(@RequestParam("img") MultipartFile file) {
        try {
            System.out.println("测试文件上传...");
            System.out.println(file.getName());
            System.out.println();
            InputStream inputStream = file.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Message(true,"");
    }

}
