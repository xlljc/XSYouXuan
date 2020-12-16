package com.xsyx.service.impl;

import com.alibaba.fastjson.JSON;
import com.xsyx.dao.UserDao;
import com.xsyx.dao.UserLogDao;
import com.xsyx.service.UserService;
import com.xsyx.utils.MyUtils;
import com.xsyx.vo.User;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserLogDao userLogDao;

    @Override
    public Message register(User user, HttpSession session) {
        //判断该用户名是否存在
        if (existName(user.getUsername())) return new Message(false,"该用户名已存在!");
        //判断该手机号是否被注册
        if (existPhone(user.getPhone())) return new Message(false, "该手机号已被注册!");

        //添加
        userDao.insert(user);
        //写入session
        MyUtils.setUserId(user.getId(),session);
        //写入日志
        userLogDao.addLog(user.getId(),"注册成为正式用户!", JSON.toJSONString(user));

        return new Message(true,user);
    }

    @Override
    public User get(Integer id) {
        return userDao.queryById(id);
    }

    @Override
    public Message login(String name, String password, HttpSession session) {
        if (name == null || password == null) return new Message(false,"登录失败! 用户名或手机号或密码错误!");
        //登录查询
        User users = userDao.login(name,password);
        if (users != null){
            //修改最后登录日期
            User user2 = new User();
            user2.setId(users.getId());
            user2.setLastLoginTime(new Timestamp(new Date().getTime()));
            userDao.updateById(user2);
            //设置session
            MyUtils.setUserId(users.getId(),session);
            //写入日志
            userLogDao.addLog(users.getId(),"登录网站",null);
            return new Message(true,users);
        }
        return new Message(false,"登录失败! 用户名或手机号或密码错误!");
    }

    /**
     * 判断该用户名是否存在
     * @return bool
     */
    private boolean existName(String name) {
        User user = new User();
        user.setUsername(name == null ? "" : name);
        return userDao.query(user).size() > 0;
    }

    /**
     * 判断该手机号是否存在
     * @return bool
     */
    private boolean existPhone(String phone) {
        User user = new User();
        user.setPhone(phone == null ? "" : phone);
        return userDao.query(user).size() > 0;
    }
}
