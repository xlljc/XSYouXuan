package com.xsyx.controller;

import com.xsyx.dao.ComOrderDao;
import com.xsyx.dao.RoleDao;

import com.xsyx.vo.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private ComOrderDao comOrderDao;

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

    @RequestMapping("/test3")
    public List<Map> test3() {
        return comOrderDao.queryOrder();
    }

}
