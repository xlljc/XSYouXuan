package com.xsyx.service.impl;


import com.xsyx.dao.PurchaseDao;
import com.xsyx.dao.UserDao;
import com.xsyx.dao.UserLogDao;
import com.xsyx.service.PurchaseService;

import com.xsyx.vo.Purchase;
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
    public int addPurchaseOrder(String applicant, String applicantremarks) {
        return purchaseDao.addPurchaseOrder(applicant,applicantremarks);
    }

    @Override
    public int queryorderidBig() {
        return purchaseDao.queryorderidBig();
    }

    @Override
    public int addPurchase(int orderid, String commodityid, String commoditysum) {
        return purchaseDao.addPurchase(orderid,commodityid,commoditysum);
    }

    @Override
    public List<Purchaseorder> querypurchaseorderAll() {
        return purchaseDao.querypurchaseorderAll();
    }

    @Override
    public List<Purchase> querycaigouAll(String orderid) {
        return purchaseDao.querycaigouAll(orderid);
    }

    @Override
    public List<Purchaseorder> purchaseorderAllnowei() {
        return purchaseDao.purchaseorderAllnowei();
    }

    @Override
    public int updatepurchaseorder(int orderid, String approvedby, String state, String approvedbyremarks) {
        return purchaseDao.updatepurchaseorder(orderid,approvedby,state,approvedbyremarks);
    }

    @Override
    public int rukuUpdateOrderstate(int orderid) {
        return purchaseDao.rukuUpdateOrderstate(orderid);
    }
}
