package com.xsyx.service.impl;


import com.xsyx.dao.PurchaseDao;
import com.xsyx.dao.UserDao;
import com.xsyx.dao.UserLogDao;
import com.xsyx.service.PurchaseService;

import com.xsyx.vo.PurchaseLinShi;
import com.xsyx.vo.Purchaseorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseDao purchaseDao;


    @Override
    public List<PurchaseLinShi> PurchaseLinShiAll() {
        return purchaseDao.PurchaseLinShiAll();
    }

    @Override
    public int addLinShiPurchase(String commodityid, String caigousum) {
        return purchaseDao.addLinShiPurchase(commodityid,caigousum);
    }

    @Override
    public int queryPurchaseLinShiBycommodityid(String commodityid) {
        return purchaseDao.queryPurchaseLinShiBycommodityid(commodityid);
    }

    @Override
    public int updatePurchaseLinShicommoditysum(String commodityid, String caigousum) {
        return purchaseDao.updatePurchaseLinShicommoditysum(commodityid,caigousum);
    }

    @Override
    public int deletePurchaseLinShi() {
        return purchaseDao.deletePurchaseLinShi();
    }

    @Override
    public List<Purchaseorder> querypurchaseorderAll() {
        return purchaseDao.querypurchaseorderAll();
    }
}
