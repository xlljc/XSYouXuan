package com.xsyx.dao;

import com.xsyx.vo.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface CollectDao {



  /**
   * 查询所有方法 
   */
  List<Collect> queryAll();

  /**
   * 根据主键id(Collect.id)查询单条数据方法 
   */
  Collect queryById(int id);

  /**
   * 根据Collect条件查询多条数据方法 
   */
  List<Collect> query(Collect collect);

  /**
   * 根据Collect插入数据方法 
   */
  int insert(Collect collect);

  /**
   * 根据Collect插入多条数据方法 
   */
  int inserts(@Param("collects") List<Collect> collects);

  /**
   * 根据Collect条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Collect collect);
}