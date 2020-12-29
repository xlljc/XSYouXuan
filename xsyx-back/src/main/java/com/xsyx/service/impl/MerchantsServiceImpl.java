package com.xsyx.service.impl;

import com.xsyx.dao.MerchantsDao;
import com.xsyx.service.MerchantsService;
import com.xsyx.vo.Merchants;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantsServiceImpl implements MerchantsService {
    @Autowired
    MerchantsDao merchantsDao;

    @Override
    public Message insert(Merchants merchants) {
        Message message = new Message(true,merchants);
        merchants.getId();
        merchantsDao.insert(merchants);
        System.out.println(merchants);
        return message;
    }
}
