package com.xsyx.dao;

import com.xsyx.vo.Purchase;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface PurchaseDao {



  /**
   * 查询所有方法 
   */
  List<Purchase> queryAll();

  /**
   * 根据主键id(Purchase.id)查询单条数据方法 
   */
  Purchase queryById(int id);

  /**
   * 根据Purchase条件查询多条数据方法 
   */
  List<Purchase> query(Purchase purchase);

  /**
   * 根据Purchase插入数据方法 
   */
  int insert(Purchase purchase);

  /**
   * 根据Purchase插入多条数据方法 
   */
  int inserts(@Param("purchases") List<Purchase> purchases);

  /**
   * 根据Purchase条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Purchase purchase);
}