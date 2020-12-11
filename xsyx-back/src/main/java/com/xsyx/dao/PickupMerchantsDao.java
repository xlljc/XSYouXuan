package com.xsyx.dao;

import com.xsyx.vo.PickupMerchants;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface PickupMerchantsDao {



  /**
   * 查询所有方法 
   */
  List<PickupMerchants> queryAll();

  /**
   * 根据主键id(PickupMerchants.id)查询单条数据方法 
   */
  PickupMerchants queryById(int id);

  /**
   * 根据PickupMerchants条件查询多条数据方法 
   */
  List<PickupMerchants> query(PickupMerchants pickupmerchants);

  /**
   * 根据PickupMerchants插入数据方法 
   */
  int insert(PickupMerchants pickupmerchants);

  /**
   * 根据PickupMerchants插入多条数据方法 
   */
  int inserts(@Param("pickupmerchantss") List<PickupMerchants> pickupmerchantss);

  /**
   * 根据PickupMerchants条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(PickupMerchants pickupmerchants);
}