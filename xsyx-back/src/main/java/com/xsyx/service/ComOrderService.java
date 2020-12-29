package com.xsyx.service;

import com.xsyx.vo.ComOrder;
import com.xsyx.vo.system.Message;

import java.util.List;

public interface ComOrderService {
    List<ComOrder> queryAlls();

    Message insert(ComOrder comOrder);

    int updateOrder(ComOrder comOrder);
}
