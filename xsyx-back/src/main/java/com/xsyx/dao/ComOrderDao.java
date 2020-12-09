package com.xsyx.dao;

import com.xsyx.vo.ComOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface ComOrderDao {



  /**
   * 查询所有方法 
   */
  List<ComOrder> queryAll();

  /**
   * 根据主键id(ComOrder.id)查询单条数据方法 
   */
  ComOrder queryById(int id);

  /**
   * 根据ComOrder条件查询多条数据方法 
   */
  List<ComOrder> query(ComOrder comorder);

  /**
   * 根据ComOrder插入数据方法 
   */
  int insert(ComOrder comorder);

  /**
   * 根据ComOrder插入多条数据方法 
   */
  int inserts(@Param("comorders") List<ComOrder> comorders);

  /**
   * 根据ComOrder条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(ComOrder comorder);
}