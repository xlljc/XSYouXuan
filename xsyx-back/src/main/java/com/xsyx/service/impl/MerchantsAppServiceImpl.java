package com.xsyx.service.impl;

import com.xsyx.dao.MerchantsApplyDao;
import com.xsyx.dao.MerchantsDao;
import com.xsyx.service.MerchantsAppService;
import com.xsyx.service.MerchantsService;
import com.xsyx.vo.Merchants;
import com.xsyx.vo.MerchantsApply;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantsAppServiceImpl implements MerchantsAppService {
    @Autowired
    private MerchantsApplyDao merchantsApplyDao;

    @Override
    public Message insert(MerchantsApply merchantsApply) {
        Message message = new Message(true, merchantsApply);
        merchantsApply.getId();
        merchantsApplyDao.insert(merchantsApply);

        return message;
    }


}
