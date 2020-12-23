package com.xsyx.controller;

import com.xsyx.service.CommodityService;
import com.xsyx.service.WareHouseService;
import com.xsyx.vo.*;
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

    //根据仓库id查询所有仓库存储商品
    @RequestMapping("/queryWareHouseStorageAll")
    public List<WareHouseStorage> queryWareHouseStorageAll(String id) {

        return wareHouseService.queryWareHouseStorageAll(id);
    }

    //根据仓库id查询所有仓库存储商品
    @RequestMapping("/warehouseAll")
    public List<Warehouse> warehouseAll() {

        return wareHouseService.warehouseAll();
    }
    //点击转库
    @RequestMapping("/zhuanku")
    public List<Warehouse> zhuanku(String commodityid,
                                String yuannumber,
                                String chuwarid,
                                String ruwarid,
                                String chunumber
                                ) {
       /* System.out.println("商品id:"+commodityid);
        System.out.println("商品原本数量:"+yuannumber);
        System.out.println("转出仓库id:"+chuwarid);
        System.out.println("转入仓库id:"+ruwarid);
        System.out.println("商品转出的数量:"+chunumber);*/

        //之前的数量减去转走的数量 变成修改的数量
        Integer updatenumber=Integer.parseInt(yuannumber)-Integer.parseInt(chunumber);

        //根据商品id 和转出仓库id 修改原仓库商品数量
        wareHouseService.updateshopnumber(commodityid,chuwarid,updatenumber.toString());


        //判断要转入的仓库有没有相同的商品 如果有相同的商品就加数量  没有才添加
        //根据转出仓库id 商品id 查询是否有结果 1是有 0是没有
        Integer jie=wareHouseService.queryshop(commodityid,chuwarid);
        /*System.out.println(jie);*/
        //如果有
        //执行添加数量操作  根据商品id和仓库id添加数量
        if (jie>0){
            wareHouseService.addshopnumber(commodityid,ruwarid,chunumber);
            //如果转库前的商品数量等于要转的数量 就删除之前的记录
            if (updatenumber==0){
                //如果updatenumber值为0 表示全部转出 删除这个仓库里的这个商品
                //根据商品id 和转出仓库id 删除原仓库商品
                wareHouseService.deleteshop(commodityid,chuwarid);
            }
        }else {
            //如果没有
            //添加一个新的记录 else
            //如果转库前的商品数量等于要转的数量 就删除之前的记录  根据记录编号删
        }
       /* wareHouseService.addshopnumber(commodityid,ruwarid,chunumber);*/
        return null;
    }

}
