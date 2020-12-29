package com.xsyx.service;

import com.xsyx.vo.Merchants;
import com.xsyx.vo.system.Message;

import javax.servlet.http.HttpSession;

public interface MerchantsService {

    Message insert(Merchants merchants);

}
