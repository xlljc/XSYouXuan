package com.xsyx.dao;

import com.xsyx.vo.Pickup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PickupDao {



  /**
   * 查询所有方法 
   */
  List<Pickup> queryAll();

  /**
   * 根据主键id(Pickup.id)查询单条数据方法 
   */
  Pickup queryById(int id);

  /**
   * 根据Pickup条件查询多条数据方法 
   */
  List<Pickup> query(Pickup pickup);

  /**
   * 根据Pickup插入数据方法 
   */
  int insert(Pickup pickup);

  /**
   * 根据Pickup插入多条数据方法 
   */
  int inserts(@Param("pickups") List<Pickup> pickups);

  /**
   * 根据Pickup条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Pickup pickup);
}