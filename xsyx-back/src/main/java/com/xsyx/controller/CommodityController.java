package com.xsyx.controller;

import com.xsyx.dao.CommodityDao;
import com.xsyx.vo.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品控制层
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityDao commodityDao;

    /**
     * 查询所有商品
     *
     * @return 商品数据
     */
    @RequestMapping("/queryAll")
    public List<Commodity> queryAll() {

        return commodityDao.queryAll();
    }

    /**
     *
     */
    @RequestMapping("/delete")
    public Message delete(Integer id) {

        return commodityDao
    }

}
