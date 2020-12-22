package com.xsyx.controller;

import com.xsyx.service.CommodityService;
import com.xsyx.service.WareHouseService;
import com.xsyx.vo.ComLabel;
import com.xsyx.vo.ComType;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.Warehouse;
import com.xsyx.vo.system.Message;
import com.xsyx.vo.system.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 仓库控制层
 */
@RestController
@RequestMapping("/warehouse")
public class WareHouseController {

    @Autowired
    WareHouseService wareHouseService;

    //分页模糊查询所有
    @RequestMapping("/queryWarehouseAll")
    public PageVo<Warehouse> queryWarehouseAll(String warname,
                                               @RequestParam(value = "page", defaultValue = "1") int page,
                                               @RequestParam(value = "rows", defaultValue = "5") int rows) {

        
        PageVo<Warehouse> l = wareHouseService.querycountWarehousebyCond(warname,page,rows);

        return l;
    }



}
