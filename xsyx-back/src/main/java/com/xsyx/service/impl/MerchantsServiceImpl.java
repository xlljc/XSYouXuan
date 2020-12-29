package com.xsyx.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsyx.dao.EmpLogDao;
import com.xsyx.dao.MerchantsDao;
import com.xsyx.dao.UserDao;
import com.xsyx.service.MerchantsService;
import com.xsyx.vo.Merchants;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantsServiceImpl implements MerchantsService {

    @Autowired
    private MerchantsDao merchantsDao;

    @Autowired
    private EmpLogDao empLogDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Message insert(Merchants merchants) {
        Message message = new Message(true, merchants);
        merchants.getId();
        merchantsDao.insert(merchants);

        return message;
    }
    @Override
    public PageInfo<Merchants> query(String str, Integer page, Integer row) {
        PageHelper.startPage(page, row);
        return new PageInfo<>(merchantsDao.queryBy(str));
    }

    @Override
    public Message delete(Integer merId, Integer empId) {
        if (empId == null) return new Message(false, "请先登录 !");
        System.out.println("merId : " + merId);
        //先把用户解绑
        userDao.unMerchant(merId);
        Merchants merchants = new Merchants();
        merchants.setId(merId);
        merchants.setState(-1);
        if (merchantsDao.updateById(merchants) > 0) {
            empLogDao.addLog(empId, "删除商户: id = " + merId, "{\"merId\": \"" + merId + "\"}");
        }
        return new Message(true, "操作成功 !");
    }

    @Override
    public Message update(Merchants merchants, Integer empId) {
        if (empId == null) return new Message(false, "请先登录 !");
        if (merchantsDao.updateById(merchants) > 0) {
            empLogDao.addLog(empId, "修改商户: id = " + merchants.getId(), JSON.toJSONString(merchants));
        }
        return new Message(true, "修改成功");
    }
}
