package com.xsyx.dao;

import com.xsyx.vo.ComDiscount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface ComDiscountDao {



  /**
   * 查询所有方法 
   */
  List<ComDiscount> queryAll();

  /**
   * 根据主键id(ComDiscount.id)查询单条数据方法 
   */
  ComDiscount queryById(int id);

  /**
   * 根据ComDiscount条件查询多条数据方法 
   */
  List<ComDiscount> query(ComDiscount comdiscount);

  /**
   * 根据ComDiscount插入数据方法 
   */
  int insert(ComDiscount comdiscount);

  /**
   * 根据ComDiscount插入多条数据方法 
   */
  int inserts(@Param("comdiscounts") List<ComDiscount> comdiscounts);

  /**
   * 根据ComDiscount条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(ComDiscount comdiscount);
}