package com.xsyx.service;

import com.github.pagehelper.PageInfo;
import com.xsyx.vo.OrderDetails;
import com.xsyx.vo.system.Message;

import java.util.List;

public interface OrderDetailsService {
    PageInfo<OrderDetails> queryForMer(String str, Integer merId, Integer state, Integer page, Integer row);

    Message shouHuo(List<Integer> ids, Integer merId);

    Message tiHuo(List<Integer> ids, Integer merId);
}
