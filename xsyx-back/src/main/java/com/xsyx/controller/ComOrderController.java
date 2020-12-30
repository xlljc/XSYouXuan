package com.xsyx.controller;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.xsyx.service.ComOrderService;
import com.xsyx.vo.ComOrder;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.Shopcar;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ord")
public class ComOrderController {
    @Autowired
    ComOrderService comOrderService;

    @RequestMapping("/query")
    public List<ComOrder> queryAlls(){
        return comOrderService.queryAlls();
    }
    @RequestMapping("/addord")
    public Message addOrd(String sid, Integer isdelete, Integer totlemoney){
        Shopcar shopcar = new Shopcar();
        ComOrder comOrder = new ComOrder();
        shopcar.setId(Integer.parseInt(sid));
        comOrder.setSid(shopcar);
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sformat.format(new Date());
        date= date.replaceAll("-","");
        date= date.replaceAll(" ","");
        date= date.replaceAll(":","");
        comOrder.setOrderNumber(date);

        comOrder.setTotlemoney(totlemoney);
        comOrder.setIsdelete(isdelete);
        return  comOrderService.insert(comOrder);
    }
    
    @RequestMapping("/upd/{id}")
    public Message updateOrder(@PathVariable Integer id, ComOrder comOrder){
        comOrder.setId(id);
        System.out.println(id+"---------");
        return comOrderService.updateOrder(comOrder);
    }

    @RequestMapping("/queryOrdbyuid")
    public List<ComOrder> queryOrderByUid(Integer uid,Integer ordstate){
        return comOrderService.queryAllByUid(uid,ordstate);
    }


}
