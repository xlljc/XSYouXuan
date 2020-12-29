package com.xsyx.service;

import com.xsyx.vo.Shopcar;
import com.xsyx.vo.system.Message;

import java.util.List;

public interface ShopcarService {

    public List<Shopcar> queryShopcarByuid(Integer uid);

    public int delShopcar(int id);

    public Shopcar queryById(int id);

    int insert(Shopcar shopcar);

    Message updateShopcar(Shopcar shopcar);
}
