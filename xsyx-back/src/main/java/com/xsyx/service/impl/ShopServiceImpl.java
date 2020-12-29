package com.xsyx.service.impl;

import com.alibaba.fastjson.JSON;
import com.xsyx.dao.ShopcarDao;
import com.xsyx.service.ShopcarService;
import com.xsyx.vo.Shopcar;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopServiceImpl implements ShopcarService {
    @Autowired
    ShopcarDao shopcarDao;

    @Override
    public List<Shopcar> queryShopcarByuid(Integer uid) {
        return shopcarDao.queryShopcarByuid(uid);
    }

    public int addShopcar(Shopcar shopcar){
        return shopcarDao.insert(shopcar);
    }

    @Override
    public int delShopcar(int id) {
        return shopcarDao.delShopcar(id);
    }
    

    @Override
    public Shopcar queryById(int id) {
        return shopcarDao.queryById(id);
    }

    @Override
    public int insert(Shopcar shopcar) {
        return shopcarDao.insert(shopcar);
    }

    @Override
    public Message updateShopcar(Shopcar shopcar) {
        shopcarDao.updateById(shopcar);
        //写入日志
        return new Message(true,shopcar);
    }


}
