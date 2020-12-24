package com.xsyx.controller;

import com.xsyx.service.PurchaseService;
import com.xsyx.service.UserService;
import com.xsyx.utils.MyUtils;
import com.xsyx.vo.*;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 采购控制层
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {


    @Autowired
    PurchaseService purchaseService;

    //查询所有临时采购表的数据
    @RequestMapping("/queryPurchaseLinShiAll")
    public List<PurchaseLinShi> PurchaseLinShiAll() {
        //System.out.println(purchaseService.PurchaseLinShiAll());
        return purchaseService.PurchaseLinShiAll();
    }

    //根据商品id 和 采购数量 向临时采购表添加数据
    @RequestMapping("/addLinShiPurchase")
    public Message addLinShiPurchase(String commodityid,String caigousum) {
        Message message = new Message();

        //判断临时采购表里 是否有这个商品 如果有 就添加数量
        //根据商品id 查询临时采购表是否有这个商品
        int jie = purchaseService.queryPurchaseLinShiBycommodityid(commodityid);
        if (jie>0){
            //根据商品id 添加数量
            int row=purchaseService.updatePurchaseLinShicommoditysum(commodityid,caigousum);

            if (row > 0) {
                message.flag = true;
                message.msg = "添加采购成功√";
                return message;
            }else {
                message.flag = false;
                message.msg = "添加采购失败×";
                return message;
            }
        }else {
            //添加记录
            int row=purchaseService.addLinShiPurchase(commodityid,caigousum);

            if (row > 0) {
                message.flag = true;
                message.msg = "添加采购成功√";
                return message;
            }else {
                message.flag = false;
                message.msg = "添加采购失败×";
                return message;
            }
        }


    }
    //计算所有临时采购表里的商品的总价
    @RequestMapping("/getLinShiPurchaseShopZon")
    public Float getLinShiPurchaseShopZon() {
        //System.out.println(purchaseService.PurchaseLinShiAll());
        List<PurchaseLinShi> arr=purchaseService.PurchaseLinShiAll();

        Float sumprice=0f;
        //计算临时采购表里的商品的总价
        for (int i=0;i<arr.size();i++){
            sumprice+=arr.get(i).getPrice()*arr.get(i).getCaigousum();
        }
        //System.out.println("sumprice : " + sumprice);
        return sumprice;
    }

    //清除所有临时采购表的数据
    @RequestMapping("/cleanPurchaseLinShi")
    public Message cleanPurchaseLinShi() {
        Message message = new Message();
       int row = purchaseService.deletePurchaseLinShi();
        if (row > 0) {
            message.flag = true;
            message.msg = "清除成功√";
            return message;
        }else {
            message.flag = false;
            message.msg = "清除失败×";
            return message;
        }
    }


    //查询所有未审核订单信息
    @RequestMapping("/querypurchaseorderAll")
    public List<Purchaseorder> querypurchaseorderAll() {

        return purchaseService.querypurchaseorderAll();
    }

}
