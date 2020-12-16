package com.xsyx.service;

import com.xsyx.vo.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityService{

    /**
     *根据商品名 还有上架状态执行模糊查询
     */
    List<Commodity> moHuquery(@Param("name") String name,
                              @Param("state") String state);

}
