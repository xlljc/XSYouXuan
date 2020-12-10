package com.xsyx.dao;

import com.xsyx.vo.Merchants;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface MerchantsDao {



  /**
   * 查询所有方法 
   */
  List<Merchants> queryAll();

  /**
   * 根据主键id(Merchants.id)查询单条数据方法 
   */
  Merchants queryById(int id);

  /**
   * 根据Merchants条件查询多条数据方法 
   */
  List<Merchants> query(Merchants merchants);

  /**
   * 根据Merchants插入数据方法 
   */
  int insert(Merchants merchants);

  /**
   * 根据Merchants插入多条数据方法 
   */
  int inserts(@Param("merchantss") List<Merchants> merchantss);

  /**
   * 根据Merchants条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Merchants merchants);
}