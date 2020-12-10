package com.xsyx.dao;

import com.xsyx.vo.Purchaseorder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface PurchaseorderDao {



  /**
   * 查询所有方法 
   */
  List<Purchaseorder> queryAll();

  /**
   * 根据主键orderid(Purchaseorder.orderid)查询单条数据方法 
   */
  Purchaseorder queryById(int id);

  /**
   * 根据Purchaseorder条件查询多条数据方法 
   */
  List<Purchaseorder> query(Purchaseorder purchaseorder);

  /**
   * 根据Purchaseorder插入数据方法 
   */
  int insert(Purchaseorder purchaseorder);

  /**
   * 根据Purchaseorder插入多条数据方法 
   */
  int inserts(@Param("purchaseorders") List<Purchaseorder> purchaseorders);

  /**
   * 根据Purchaseorder条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Purchaseorder purchaseorder);
}