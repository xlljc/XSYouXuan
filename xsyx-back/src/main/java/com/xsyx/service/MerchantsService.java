package com.xsyx.service;

import com.github.pagehelper.PageInfo;
import com.xsyx.vo.Merchants;
import com.xsyx.vo.system.Message;

public interface MerchantsService {
    PageInfo<Merchants> query(String str, Integer page, Integer row);

    Message delete(Integer merId, Integer empId);

    Message update(Merchants merchants, Integer empId);
}
