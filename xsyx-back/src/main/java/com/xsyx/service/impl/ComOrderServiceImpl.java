package com.xsyx.service.impl;

import com.xsyx.dao.ComOrderDao;
import com.xsyx.service.ComOrderService;
import com.xsyx.vo.ComOrder;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComOrderServiceImpl implements ComOrderService {
    @Autowired
    ComOrderDao comOrderDao;

    @Override
    public List<ComOrder> queryAlls() {
        return comOrderDao.queryAlls();
    }

    @Override
    public Message insert(ComOrder comOrder) {
        Message message=new Message();
        comOrderDao.insert(comOrder);
        comOrder.getId();

        message.setMsg(comOrder.getId());
        System.out.println(comOrder.getIsdelete());
        return message;
    }

    public int updateOrder(ComOrder comOrder){
        return comOrderDao.updateById(comOrder);
    }

    @Override
    public List<ComOrder> queryAllByUid(Integer uid) {
        return comOrderDao.queryAllByUid(uid);
    }
}
