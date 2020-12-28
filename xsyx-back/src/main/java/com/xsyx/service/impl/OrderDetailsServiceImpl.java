package com.xsyx.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsyx.dao.MerLogDao;
import com.xsyx.dao.OrderDetailsDao;
import com.xsyx.service.OrderDetailsService;
import com.xsyx.vo.OrderDetails;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private MerLogDao merLogDao;

    @Override
    public PageInfo<OrderDetails> queryForMer(String str, Integer merId, Integer state, Integer page, Integer row) {
        if (merId == null)return new PageInfo<>();
        PageHelper.startPage(page,row);
        return new PageInfo<>(orderDetailsDao.queryForMer(str,merId,state));
    }

    @Override
    public Message shouHuo(List<Integer> ids, Integer merId) {
        if (merId == null) return new Message(false,"请先登录 !");
        if (ids.size() > 0) {
            merLogDao.addLog(merId,"收货", JSON.toJSONString(ids));
            orderDetailsDao.setState(ids,1);
        }
        return new Message(true,"收货成功 !");
    }

    @Override
    public Message tiHuo(List<Integer> ids, Integer merId) {
        if (merId == null) return new Message(false,"请先登录 !");
        if (ids.size() > 0) {
            merLogDao.addLog(merId,"提货", JSON.toJSONString(ids));
            orderDetailsDao.setState(ids,2);
        }
        return new Message(true,"提货成功 !");
    }
}
