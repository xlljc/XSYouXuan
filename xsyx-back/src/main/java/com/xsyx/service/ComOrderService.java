package com.xsyx.service;

import com.xsyx.vo.ComOrder;
import com.xsyx.vo.system.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComOrderService {
    List<ComOrder> queryAlls();

    /**
     * 根据ComOrder条件查询多条数据方法
     */
    List<ComOrder> query(ComOrder comorder,@Param("ordstate") Integer ordstate);

    Message insert(ComOrder comOrder);

    Message updateOrder(ComOrder comOrder);

    List<ComOrder> queryAllByUid(Integer uid,Integer ordstate);
}
