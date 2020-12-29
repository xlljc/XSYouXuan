package com.xsyx.controller;

import com.xsyx.service.DistributionService;
import com.xsyx.service.MenuService;
import com.xsyx.service.WareHouseService;
import com.xsyx.vo.Distribution;
import com.xsyx.vo.Menu;
import com.xsyx.vo.Warehouse;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 配送控制层
 */
@RestController
@RequestMapping("/peison")
public class DistributionController {

    @Autowired
    private DistributionService distributionService;
    @Autowired
    private WareHouseService wareHouseService;

    /**
     * 查询所有订单数据
     */
    @RequestMapping("/peisonAll")
    public List<Distribution> querypeisonAll() {

        //System.out.println(distributionService.querypeisonAll());

        return distributionService.querypeisonAll();
    }

    //查询所有拥有这个商品的仓库的数据
    @RequestMapping("/warehouseAllByshopid")
    public List<Warehouse> warehouseAllByshopid(String shopid) {
        //System.out.println(shopid);

        //根据商品id查询拥有这个商品的仓库
        //System.out.println(distributionService.warehouseAllByshopid(shopid));
        return distributionService.warehouseAllByshopid(shopid);
    }

    //根据仓库id 查询这个仓库里的这个商品的数量
    @RequestMapping("/querywarehouseshopsum")
    public Integer querywarehouseshopsum(String warid,
                                         String shopid) {

        return distributionService.querywarehouseshopsum(warid, shopid);
    }

    //点击确认配送
    @RequestMapping("/querenpeison")
    public Message querenpeison(String warid,
                                String shopid,
                                String xuqiushopsum,
                                String guige,
                                String ddid) {
        //拿到仓库id
        //拿到商品id
        //拿到配送数量
        //商品规格
        //订单id  ordernumber 编号
        Message message = new Message();

        //如果配送数量等于仓库容量 删除 表商品数据
        int cangsum=distributionService.querywarehouseshopsum(warid, shopid);
        if (cangsum==Integer.parseInt(xuqiushopsum)){
            //删除中间表里的这个商品
            distributionService.deleteshop(warid,shopid);
        }
        //修改 仓库商品中间表的商品数量数据
        distributionService.updateshopsum(warid,shopid,xuqiushopsum);
        //计算 这个订单的商品容量
        Float shopron =Float.parseFloat(xuqiushopsum)*Float.parseFloat(guige);
        //修改仓库的容量 转出 增加仓库容量
        wareHouseService.updateWareHouseRon(warid,shopron.toString());

        //根据订单修改订单状态 为待收货 1
        distributionService.updatedingdanstate(ddid);
        message.flag = true;
        message.msg = "配送成功√";
        return message;
    }
}
