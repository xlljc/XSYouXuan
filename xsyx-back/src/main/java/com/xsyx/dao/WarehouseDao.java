package com.xsyx.dao;

import com.xsyx.vo.Commodity;
import com.xsyx.vo.Warehouse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface WarehouseDao {

  //条件查询 显示所有的仓库信息
  List<Warehouse> queryWarehouseAll(@Param("warname") String warname);
  // 根据条件查询仓库总数量
  int querycountWarehousebyCond(@Param("warname") String warname);
}
