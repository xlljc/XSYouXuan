package com.xsyx.controller;

import com.xsyx.service.PurchaseService;
import com.xsyx.service.UserService;
import com.xsyx.service.WareHouseService;
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
    @Autowired
    WareHouseService wareHouseService;

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
    //获取所有临时采购表的数据  生成采购订单 生成采购单
    @RequestMapping("/addCaiGou")
    public Message addCaiGou(
            //员工id
            String applicant,
            //申请人备注
            String applicantremarks) {
        Message message = new Message();
         //生成订单详情表 未审核记录
        //参数：当前采购的员工id  申请人备注（就是仓库）
        purchaseService.addPurchaseOrder(applicant,applicantremarks);
       //查询所有临时订单表的数据
        //System.out.println(purchaseService.PurchaseLinShiAll());
        List<PurchaseLinShi> arr=  purchaseService.PurchaseLinShiAll();
        //将临时订单表数据添加到  采购表  订单id 商品id 商品数量
        //查询订单详情表的最大订单号
        int orderid = purchaseService.queryorderidBig();
        for (int i=0;i<arr.size();i++){
            purchaseService.addPurchase(orderid,arr.get(i).getId().toString(),arr.get(i).getPrice().toString());
        }
        message.flag = true;
        message.msg = "提交采购申请成功√";
        return message;
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

    //审核部分-------------
    //查询所有未审核订单信息
    @RequestMapping("/querypurchaseorderAll")
    public List<Purchaseorder> querypurchaseorderAll() {

        return purchaseService.querypurchaseorderAll();
    }

    //根据订单id 查询所有采购商品
    @RequestMapping("/querycaigouAll")
    public List<Purchase> querycaigouAll(String orderid) {
        //System.out.println(orderid);
        return purchaseService.querycaigouAll(orderid);
    }

    //查询所有不是未审核订单信息
    @RequestMapping("/purchaseorderAllnowei")
    public List<Purchaseorder> purchaseorderAllnowei() {

        return purchaseService.purchaseorderAllnowei();
    }
    //提交审核
    @RequestMapping("/shenHe")
    public Message shenHe(
            //获取订单id
            int orderid,
            //获取当前用户id  做审核人
            String approvedby,
            //传一个表示同意的参数 1 修改状态  拒绝传-1
            String state,
            //获取审批人备注
            String approvedbyremarks) {
        Message message = new Message();
        /*System.out.println(orderid);
        System.out.println(approvedby);
        System.out.println(state);
        System.out.println(approvedbyremarks);*/
        //修改订单状态  1是采购中
        purchaseService.updatepurchaseorder(orderid,approvedby,state,approvedbyremarks);

        message.flag = true;
        message.msg = "审核成功√";
        return message;
    }
    //模拟采购流程 计时30秒后执行修改订单状态为采购成功
    //根据订单id 修改订单状态为2
    @RequestMapping("/caigouwancheng")
    public Message caigouwancheng(
            //获取订单id
            int orderid,
            //获取当前用户id  做审核人
            String approvedby,
            //传一个表示同意的参数 1 修改状态  拒绝传-1
            String state,
            //获取审批人备注
            String approvedbyremarks) {
        Message message = new Message();

        //根据订单id 修改订单状态为2 采购完成
        purchaseService.updatepurchaseorder(orderid,approvedby,"2",approvedbyremarks);

        message.flag = true;
        message.msg = "采购完成√";
        return message;
    }

    //入库
    @RequestMapping("/ruku")
    public Message ruku(
            //获取仓库id
            String warehouseid,
            //获取订单id
            String orderid) {
        Message message = new Message();

        //根据订单id 获取改订单所有商品
        List<Purchase> arr = purchaseService.querycaigouAll(orderid);

        //根据商品id 仓库id 执行入库
        for (int i=0;i<arr.size();i++) {
            //判断要转入的仓库有没有相同的商品 如果有相同的商品就加数量  没有才添加
            //根据转入仓库id 商品id 查询是否有结果 1是有 0是没有
            Integer jie = wareHouseService.queryshop(arr.get(i).getCommodityid(), warehouseid);
            //如果有
            if (jie > 0) {
                //执行添加数量操作  根据商品id和转入仓库id添加数量
                wareHouseService.addshopnumber(arr.get(i).getCommodityid(), warehouseid, arr.get(i).getCommoditysum().toString());
                //根据转入仓库id 修改转入仓库的容量
                //计算这个商品的容量
                Float shopron = Float.parseFloat(arr.get(i).getCommoditysum().toString()) * Float.parseFloat(arr.get(i).getSpecification());
                wareHouseService.updateWareHouseRon1(warehouseid, shopron.toString());
            } else {
                //如果没有
                //添加一个新的记录 else
                wareHouseService.addwarehousestorageshop(arr.get(i).getCommodityid(), warehouseid, arr.get(i).getCommoditysum().toString());
                //修改转入仓库的容量
                //计算这个商品的容量
                Float shopron = Float.parseFloat(arr.get(i).getCommoditysum().toString()) * Float.parseFloat(arr.get(i).getSpecification());
                wareHouseService.updateWareHouseRon1(warehouseid, shopron.toString());
            }
        }
        //修改订单状态为已入库  3
        purchaseService.rukuUpdateOrderstate(Integer.parseInt(orderid));
        message.flag = true;
        message.msg = "入库完成√";
        return message;
    }


}
