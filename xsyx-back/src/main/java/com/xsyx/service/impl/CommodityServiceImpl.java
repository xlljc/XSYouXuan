package com.xsyx.service.impl;

import com.xsyx.dao.CommodityDao;
import com.xsyx.dao.MenuDao;
import com.xsyx.service.CommodityService;
import com.xsyx.service.MenuService;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityDao commodityDao;

    @Override
    public List<Commodity> moHuquery(String name, String state) {
        return commodityDao.moHuquery(name,state);
    }
}
