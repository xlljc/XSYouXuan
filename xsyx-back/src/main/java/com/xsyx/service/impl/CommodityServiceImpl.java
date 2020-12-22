package com.xsyx.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsyx.dao.CommodityDao;
import com.xsyx.dao.MenuDao;
import com.xsyx.service.CommodityService;
import com.xsyx.service.MenuService;
import com.xsyx.vo.ComType;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.Menu;
import com.xsyx.vo.system.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityDao commodityDao;

    @Override
    public List<Commodity> queryCommodityAll(String name, String state, int page, int rows) {
        PageHelper.startPage(page, rows);
        return commodityDao.queryCommodityAll(name,state);
    }

    @Override
    public PageVo<Commodity> querycountCommoditybyCond(String name, String state, int page, int rows) {
        PageVo<Commodity> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(commodityDao.queryCommodityAll(name,state));
        //获取总的记录数量
        pageVo.setTotal(commodityDao.querycountCommoditybyCond(name,state));
        return pageVo;
    }

    @Override
    public List<ComType> queryAlltype() {
        return commodityDao.queryAlltype();
    }

    @Override
    public List<Commodity> moHuquery(String name, String state) {
        return commodityDao.moHuquery(name,state);
    }

    @Override
    public int addCommodity(String name, String particulars, String image, String price, String unit, String specification, String manufacturer, String type) {
        return commodityDao.addCommodity(name,particulars,image,price,unit,specification,manufacturer,type);
    }
}
