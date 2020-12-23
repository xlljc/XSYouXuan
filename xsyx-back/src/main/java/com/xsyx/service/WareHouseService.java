package com.xsyx.service;

import com.xsyx.vo.*;
import com.xsyx.vo.system.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WareHouseService {

    //条件查询 显示所有的仓库信息
    List<Warehouse> queryWarehouseAll(@Param("warname") String warname,int page, int rows);
    // 根据条件查询仓库总数量
    PageVo<Warehouse> querycountWarehousebyCond(@Param("warname") String warname,int page, int rows);

    //根据仓库id查询所有仓库存储商品
    List<WareHouseStorage> queryWareHouseStorageAll(String id);
    //查询所有仓库
    List<Warehouse> warehouseAll();
    //根据商品id 和转出仓库id 修改原仓库商品数量
    int updateshopnumber(@Param("commodityid") String commodityid,
                         @Param("chuwarid") String chuwarid,
                         @Param("updatenumber") String updatenumber);
    //根据商品id 和转出仓库id 删除原仓库商品
    int deleteshop(@Param("commodityid") String commodityid,
                   @Param("chuwarid") String chuwarid);
    //根据转出仓库id 商品id 查询是否有结果
    int queryshop(@Param("commodityid") String commodityid,
                  @Param("chuwarid") String chuwarid);
    //执行添加数量操作  根据商品id和仓库id添加数量
    int addshopnumber(@Param("commodityid") String commodityid,
                      @Param("ruwarid") String ruwarid,
                      @Param("chunumber") String chunumber);
    
    //给转入仓库添加一条新数据
    int addwarehousestorageshop(@Param("commodityid") String commodityid,
                      @Param("ruwarid") String ruwarid,
                      @Param("chunumber") String chunumber);

}
