package com.xsyx.service.impl;

import com.xsyx.dao.MenuDao;
import com.xsyx.service.MenuService;
import com.xsyx.vo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> queryAll() {
        return menuDao.queryAllAndChild();
    }
}
