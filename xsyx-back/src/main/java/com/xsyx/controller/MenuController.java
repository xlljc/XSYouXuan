package com.xsyx.controller;

import com.xsyx.service.MenuService;
import com.xsyx.vo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单控制层
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询所有菜单
     * @return 菜单数据
     */
    @RequestMapping("/queryAll")
    public List<Menu> queryAll() {
        return menuService.queryAll();
    }

}
