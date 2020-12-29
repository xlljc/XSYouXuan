package com.xsyx.controller;

import com.xsyx.service.CollectService;
import com.xsyx.vo.Collect;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.Shopcar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    CollectService collectService;

    @RequestMapping("/query")
    public List<Collect> query(){
        System.out.println(collectService.queryAll());
        return collectService.queryAll();

    }


    @RequestMapping("/add")
    public int addCol(String cid){
        Collect collect=new Collect();

        Commodity commodity = new Commodity();
        commodity.setId(Integer.parseInt(cid));

        collect.setCid(commodity);

        return collectService.insert(collect);
    }
}
