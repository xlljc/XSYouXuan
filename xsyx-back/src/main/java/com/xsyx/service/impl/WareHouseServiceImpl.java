package com.xsyx.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsyx.dao.CommodityDao;
import com.xsyx.dao.WarehouseDao;
import com.xsyx.service.CommodityService;
import com.xsyx.service.WareHouseService;
import com.xsyx.vo.*;
import com.xsyx.vo.system.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WareHouseServiceImpl implements WareHouseService {

    @Autowired
    WarehouseDao warehouseDao;


    @Override
    public List<Warehouse> queryWarehouseAll(String warname, int page, int rows) {
        PageHelper.startPage(page, rows);
        return warehouseDao.queryWarehouseAll(warname);
    }

    @Override
    public PageVo<Warehouse> querycountWarehousebyCond(String warname, int page, int rows) {
        PageVo<Warehouse> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(warehouseDao.queryWarehouseAll(warname));
        //获取总的记录数量
        pageVo.setTotal(warehouseDao.querycountWarehousebyCond(warname));
        return pageVo;
    }

    @Override
    public List<WareHouseStorage> queryWareHouseStorageAll(String id) {
        return warehouseDao.queryWareHouseStorageAll(id);
    }

    @Override
    public List<Warehouse> warehouseAll() {
        return warehouseDao.warehouseAll();
    }

    @Override
    public int updateshopnumber(String commodityid, String chuwarid, String updatenumber) {
        return warehouseDao.updateshopnumber(commodityid,chuwarid,updatenumber);
    }

    @Override
    public int deleteshop(String commodityid, String chuwarid) {
        return warehouseDao.deleteshop(commodityid,chuwarid);
    }

    @Override
    public int queryshop(String commodityid, String chuwarid) {
        return warehouseDao.queryshop(commodityid,chuwarid);
    }

    @Override
    public int addshopnumber(String commodityid, String ruwarid, String chunumber) {
        return warehouseDao.addshopnumber(commodityid,ruwarid,chunumber);
    }

    @Override
    public int addwarehousestorageshop(String commodityid, String ruwarid, String chunumber) {
        return warehouseDao.addwarehousestorageshop(commodityid,ruwarid,chunumber);
    }


}
