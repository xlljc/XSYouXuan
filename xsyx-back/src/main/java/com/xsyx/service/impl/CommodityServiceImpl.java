package com.xsyx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsyx.dao.CommodityDao;
import com.xsyx.dao.MenuDao;
import com.xsyx.service.CommodityService;
import com.xsyx.service.MenuService;
import com.xsyx.vo.ComLabel;
import com.xsyx.vo.ComType;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.Menu;
import com.xsyx.vo.system.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public int addCommodityType(String name) {
        return commodityDao.addCommodityType(name);
    }

    @Override
    public int updateCommodityType(String id, String name) {
        return commodityDao.updateCommodityType(id,name);
    }

    @Override
    public int deleteCommodityType(String id) {
        return commodityDao.deleteCommodityType(id);
    }

    @Override
    public List<Commodity> moHuquery(String name, String state) {
        return commodityDao.moHuquery(name,state);
    }

    @Override
    public int addCommodity(String name, String particulars, String image, String price, String unit, String specification, String manufacturer, String type) {
        return commodityDao.addCommodity(name,particulars,image,price,unit,specification,manufacturer,type);
    }

    @Override
    public int updateCommodity(String name, String particulars, String image, String price, String unit, String specification, String manufacturer, String type, String id) {
        return commodityDao.updateCommodity(name,particulars,image,price,unit,specification,manufacturer,type,id);
    }

    @Override
    public int deleteCommodity(String id) {
        return commodityDao.deleteCommodity(id);
    }

    @Override
    public int up(String id, String putawayDate) {
        return commodityDao.up(id,putawayDate);
    }


    @Override
    public List<ComLabel> queryAllLabel() {
        return commodityDao.queryAllLabel();
    }

    @Override
    public Commodity querySpByid(int id) {
        return commodityDao.querySpByid(id);
    }

    @Override
    public Map<String, Object> queryHome() {
        Map<String,Object> map = new HashMap<>();
        //查询首页的--新品上市
        List<Commodity> commodities1 = commodityDao.queryNewReleases();
        map.put("newReleases",commodities1);
        //查询热销商品
        List<Commodity> commodities2 = commodityDao.queryHotSale();
        map.put("hotSale",commodities2);
        //查询猜你喜欢
        List<Commodity> commodities3 = commodityDao.queryGuessLikes();
        map.put("guessLikes",commodities3);
        return map;
    }

    @Override
    public List<Commodity> searchTips(String str) {
        return commodityDao.searchTips(str);
    }

    @Override
    public PageInfo<Commodity> search(String str, int page, int rows) {
        PageHelper.startPage(page,rows);
        return new PageInfo<>(commodityDao.search(str));
    }
}
