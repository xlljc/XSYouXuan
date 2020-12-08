package com.xsyx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 测试
     */
    @RequestMapping("/test1")
    public Map<String,String> test1() {
        Map<String,String> map = new HashMap<>();
        map.put("title","标题");
        return map;
    }

}
