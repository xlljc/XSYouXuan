package com.xsyx.service;

import com.xsyx.vo.ComLabel;
import com.xsyx.vo.ComType;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.Warehouse;
import com.xsyx.vo.system.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WareHouseService {

    //条件查询 显示所有的仓库信息
    List<Warehouse> queryWarehouseAll(@Param("warname") String warname,int page, int rows);
    // 根据条件查询仓库总数量
    PageVo<Warehouse> querycountWarehousebyCond(@Param("warname") String warname,int page, int rows);

}
