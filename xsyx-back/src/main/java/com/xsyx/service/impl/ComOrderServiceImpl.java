package com.xsyx.service.impl;

import com.xsyx.dao.ComOrderDao;
import com.xsyx.service.ComOrderService;
import com.xsyx.vo.ComOrder;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.system.Message;
import org.apache.ibatis.annotations.Param;
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
    public List<ComOrder> query(ComOrder comorder,@Param("ordstate") Integer ordstate) {
        return comOrderDao.query(comorder,ordstate);
    }

    @Override
    public Message insert(ComOrder comOrder) {
        Message message=new Message();
        comOrderDao.insert(comOrder);
        comOrder.getId();

        message.setMsg(comOrder.getId());
        return message;
    }

    public Message updateOrder(ComOrder comOrder){

        comOrderDao.updateById(comOrder);
        return new Message(true,comOrder);
    }

    @Override
    public List<ComOrder> queryAllByUid(Integer uid,Integer ordstate) {
        return comOrderDao.queryAllByUid(uid,ordstate);
    }
}
