package com.xsyx.service.impl;

import com.xsyx.dao.ComOrderDao;
import com.xsyx.service.ComOrderService;
import com.xsyx.vo.ComOrder;
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
    public int insert(ComOrder comOrder) {
        return comOrderDao.insert(comOrder);
    }
}
