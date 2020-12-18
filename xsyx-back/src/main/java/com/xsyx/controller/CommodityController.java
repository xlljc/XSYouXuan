package com.xsyx.controller;

import com.github.pagehelper.PageInfo;
import com.xsyx.dao.CommodityDao;
import com.xsyx.service.CommodityService;
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
    @Autowired
    private CommodityService commodityService;

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
     * 模糊查询所有商品
     *
     * @return 商品数据
     */
    @RequestMapping("/MoHuqueryAll")
    public List<Commodity> moHuqueryAll(String name,String state) {
        if (state.equals("全部")){
            state="";
        }
        if (state.equals("上架")){
            state="1";
        }
        if (state.equals("下架")){
            state="0";
        }
        /*System.out.println(commodityService.MoHuquery(name,state));*/
        return commodityService.moHuquery(name,state);
    }

    /**
     *根据id下架商品
     *
     */
    /*@RequestMapping("/delete")
    public Message delete(Integer id, HttpSession session) {

        return employeeService.delete(id, session);
    }*/

}
