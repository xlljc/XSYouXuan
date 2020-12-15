package com.xsyx.controller;

import com.xsyx.service.UserService;
import com.xsyx.utils.MyUtils;
import com.xsyx.vo.User;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 用户控制层
 * @author 李锦程
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    /**
     * 注册用户
     *
     * @param user 员工信息
     * @return 返回消息, 包含是否注册成功, 注册信息
     */
    @RequestMapping("/register")
    public Message register(User user, HttpSession session) {
        return userService.register(user,session);
    }

    /**
     * 根据用户id查询用户
     *
     * @param id id值
     * @return 用户信息
     */
    @RequestMapping("/get/{id}")
    public User get(@PathVariable Integer id) {
        return userService.get(id);
    }

    /**
     * 返回当前用户信息
     *
     * @return 用户信息
     */
    @RequestMapping("/get")
    public User get(HttpSession session) {
        Integer id = MyUtils.getUserId(session);
        if (id == null) return null;
        return userService.get(id);
    }

    /**
     * 用户登录, 返回登录信息, 登录储存在session中
     *
     * @param name     登录用户名
     * @param password 登录密码
     * @return 如果登录成功, 就返回true和用户信息, 如果登录失败就返回false和失败信息
     */
    @RequestMapping("/login")
    public Message login(@RequestParam("name") String name, @RequestParam("password") String password, HttpSession session) {
        System.out.println("用户登录： " + name + " " + password);
        return userService.login(name, password, session);
    }


}
