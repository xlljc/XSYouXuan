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

import java.util.*;

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
            System.out.println("收货：");
            //merLogDao.addLog(merId,"收货", JSON.toJSONString(ids));
            orderDetailsDao.setShouHuo(ids);
        }
        return new Message(true,"收货成功 !");
    }

    @Override
    public Message tiHuo(List<Integer> ids, Integer merId) {
        if (merId == null) return new Message(false,"请先登录 !");
        if (ids.size() > 0) {
            //merLogDao.addLog(merId,"提货", JSON.toJSONString(ids));
            System.out.println("提货：");
            orderDetailsDao.setTiHuo(ids);
        }
        return new Message(true,"提货成功 !");
    }

    @Override
    public Map<String, Object> statistical(Integer merId, Integer day) {
        Map<String,Object> map = new HashMap<>();

        //商品与销售数量
        List<Map<String, Object>> list = orderDetailsDao.queryIncomeByCom(merId, day);
        //总收入
        float sum = 0f;
        for (Map<String, Object> i : list) {
            Object o = i.get("value");
            if (o != null)
                sum += Float.parseFloat(o.toString());
        }
        //每个时间段的数量
        List<Map<String, Object>> list1 = orderDetailsDao.queryDateSum(merId, day);
        //昨日收入
        int yesterdayIncome = orderDetailsDao.queryYesterdayIncome(merId);

        List<Map<String, Object>> list2 = orderDetailsDao.queryStateCount(merId);
        //待收数量
        long shouHuoCount = 0;
        //待提数量
        long tiHuoCount = 0;
        for (Map<String, Object> i : list2) {
            Object temp = i.get("ordstate");
            if (temp.equals(1)) {
                shouHuoCount = (long) i.get("count");
            } else if (temp.equals(2)) {
                tiHuoCount = (long) i.get("count");
            }
        }

        //写入
        map.put("comIncome",list); //商品与销售数量
        map.put("sum",sum); //总收入
        map.put("timeIncome",list1); //时间段收入
        map.put("shouHuoCount",shouHuoCount); //待收数量
        map.put("tiHuoCount",tiHuoCount); //待提数量
        map.put("yesterdayIncome",yesterdayIncome); //昨日收入

        return map;
    }
}
