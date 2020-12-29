package com.xsyx.service;

import com.xsyx.vo.User;
import com.xsyx.vo.system.Message;

import javax.servlet.http.HttpSession;

public interface UserService {

    Message register(User user, HttpSession session);

    Message updateById(User user);

    User get(Integer id);

    Message login(String name, String password, HttpSession session);

}
