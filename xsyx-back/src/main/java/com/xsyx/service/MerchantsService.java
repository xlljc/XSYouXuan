package com.xsyx.service;

import com.xsyx.vo.Merchants;
import com.xsyx.vo.system.Message;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;

public interface MerchantsService {

    Message insert(Merchants merchants);

    PageInfo<Merchants> query(String str, Integer page, Integer row);

    Message delete(Integer merId, Integer empId);

    Message update(Merchants merchants, Integer empId);

}
