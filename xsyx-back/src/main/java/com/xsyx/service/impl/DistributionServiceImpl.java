package com.xsyx.service.impl;

import com.xsyx.dao.DistributionDao;
import com.xsyx.dao.MenuDao;
import com.xsyx.service.DistributionService;
import com.xsyx.service.MenuService;
import com.xsyx.vo.Distribution;
import com.xsyx.vo.Menu;
import com.xsyx.vo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionServiceImpl implements DistributionService {

    @Autowired
    private DistributionDao distributionDao;


    @Override
    public List<Distribution> querypeisonAll() {
        return distributionDao.querypeisonAll();
    }

    @Override
    public List<Warehouse> warehouseAllByshopid(String shopid) {
        return distributionDao.warehouseAllByshopid(shopid);
    }

    @Override
    public int querywarehouseshopsum(String warid, String shopid) {
        return distributionDao.querywarehouseshopsum(warid,shopid);
    }

    @Override
    public int updateshopsum(String warid, String shopid, String xuqiushopsum) {
        return distributionDao.updateshopsum(warid,shopid,xuqiushopsum);
    }

    @Override
    public int deleteshop(String warid, String shopid) {
        return distributionDao.deleteshop(warid,shopid);
    }

    @Override
    public int updatedingdanstate(String ddid) {
        return distributionDao.updatedingdanstate(ddid);
    }
}
