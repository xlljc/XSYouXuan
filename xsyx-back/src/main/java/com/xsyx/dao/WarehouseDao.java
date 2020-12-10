package com.xsyx.dao;

import com.xsyx.vo.Warehouse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface WarehouseDao {



  /**
   * 查询所有方法 
   */
  List<Warehouse> queryAll();

  /**
   * 根据主键warid(Warehouse.warid)查询单条数据方法 
   */
  Warehouse queryById(int id);

  /**
   * 根据Warehouse条件查询多条数据方法 
   */
  List<Warehouse> query(Warehouse warehouse);

  /**
   * 根据Warehouse插入数据方法 
   */
  int insert(Warehouse warehouse);

  /**
   * 根据Warehouse插入多条数据方法 
   */
  int inserts(@Param("warehouses") List<Warehouse> warehouses);

  /**
   * 根据Warehouse条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Warehouse warehouse);
}