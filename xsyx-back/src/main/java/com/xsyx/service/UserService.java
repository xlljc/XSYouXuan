package com.xsyx.service;

import com.github.pagehelper.PageInfo;
import com.xsyx.vo.User;
import com.xsyx.vo.system.Message;

import javax.servlet.http.HttpSession;

public interface UserService {

    Message register(User user, HttpSession session);

    Message updateById(User user);

    User get(Integer id);

    Message login(String name, String password, HttpSession session);

    PageInfo<User> query(String str, String sex, Integer isRealName, Integer page, Integer row);

    Message update(User user, Integer empId);

    Message delete(Integer userId, Integer empId);
}
