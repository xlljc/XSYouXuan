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
    public int updateWareHouseRon(String chuwarid, String shopron) {
        return warehouseDao.updateWareHouseRon(chuwarid,shopron);
    }

    @Override
    public int deleteshop(String commodityid, String chuwarid) {
        return warehouseDao.deleteshop(commodityid,chuwarid);
    }

    @Override
    public int queryshop(String commodityid, String ruwarid) {
        return warehouseDao.queryshop(commodityid,ruwarid);
    }

    @Override
    public int addshopnumber(String commodityid, String ruwarid, String chunumber) {
        return warehouseDao.addshopnumber(commodityid,ruwarid,chunumber);
    }

    @Override
    public int updateWareHouseRon1(String ruwarid, String shopron) {
        return warehouseDao.updateWareHouseRon1(ruwarid,shopron);
    }

    @Override
    public int addwarehousestorageshop(String commodityid, String ruwarid, String chunumber) {
        return warehouseDao.addwarehousestorageshop(commodityid,ruwarid,chunumber);
    }

    @Override
    public int updateWareHouseWarstate(String warid, String warstate) {
        return warehouseDao.updateWareHouseWarstate(warid,warstate);
    }

    @Override
    public int addWarehouse(String warname, String wartype, String warcapacity, String waraddress) {
        return warehouseDao.addWarehouse(warname,wartype,warcapacity,waraddress);
    }

    @Override
    public int updateWarehouse(String warname, String wartype, String warcapacity, String waraddress, String warid) {
        return warehouseDao.updateWarehouse(warname,wartype,warcapacity,waraddress,warid);
    }

    @Override
    public int deleteWarehouse(String warid) {
        return warehouseDao.deleteWarehouse(warid);
    }

    @Override
    public int queryWarehouseshop(String warid) {
        return warehouseDao.queryWarehouseshop(warid);
    }


}
