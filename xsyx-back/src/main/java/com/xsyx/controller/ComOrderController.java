package com.xsyx.controller;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.xsyx.service.ComOrderService;
import com.xsyx.vo.ComOrder;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.Shopcar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public int addOrd(String sid,String ordernumber,Integer totlemoney){
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

        return comOrderService.insert(comOrder);
    }
}
