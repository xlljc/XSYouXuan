package com.xsyx.controller;

import com.github.pagehelper.PageInfo;
import com.xsyx.service.UserService;
import com.xsyx.utils.MyUtils;
import com.xsyx.vo.User;
import com.xsyx.vo.system.Message;
import org.apache.ibatis.annotations.Param;
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


    /**
     * 查询角色带分页
     * @param sex 性别
     * @param str 查询条件
     * @param page 页数
     * @param row 每页条数
     * @return
     */
    @RequestMapping("/query")
    public PageInfo<User> query(String sex, String str, Integer isRealName,
                                @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer row) {
        return userService.query(str,sex, isRealName,page,row);
    }

    /**
     * 修改客户
     * @param user 客户信息
     * @param empId 操作员id
     * @return 消息
     */
    @RequestMapping("/update")
    public Message update(User user,Integer empId) {
        return userService.update(user,empId);
    }

    /**
     * 删除客户
     * @param userId 客户id
     * @param empId 操作员id
     * @return 信息
     */
    @RequestMapping("/delete")
    public Message delete(Integer userId, Integer empId) {
        return userService.delete(userId,empId);
    }

}
