package com.xsyx.controller;

import com.xsyx.service.ShopcarService;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.Shopcar;
import com.xsyx.vo.User;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shopcar")
public class ShopcarController {
    @Autowired
    ShopcarService shopcarService;
    @RequestMapping("/queryshopbyuid/{uid}")
    public List<Shopcar> queryShopcarByuid(@PathVariable Integer uid){
        return shopcarService.queryShopcarByuid(uid);
    }

    @RequestMapping("/del")
    public int delShopcar(@RequestParam("id") Integer id){
        return shopcarService.delShopcar(id);
    }

    @RequestMapping("/queryid")
    public Shopcar queryByid(@RequestParam("id") Integer id){
        return shopcarService.queryById(id);
    }

    @RequestMapping("/add")
    public int addShop(String cid,String number,User uid){
        Shopcar shopcar = new Shopcar();
        Commodity commodity = new Commodity();
        commodity.setId(Integer.parseInt(cid));
        shopcar.setUid(uid);
        shopcar.setCid(commodity);
        return shopcarService.insert(shopcar);
    }

    @RequestMapping("/update")
    public Message updateById(Shopcar shopcar){
        return shopcarService.updateShopcar(shopcar);
    }
}
