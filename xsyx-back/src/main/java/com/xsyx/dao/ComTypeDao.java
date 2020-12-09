package com.xsyx.dao;

import com.xsyx.vo.ComType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface ComTypeDao {



  /**
   * 查询所有方法 
   */
  List<ComType> queryAll();

  /**
   * 根据主键id(ComType.id)查询单条数据方法 
   */
  ComType queryById(int id);

  /**
   * 根据ComType条件查询多条数据方法 
   */
  List<ComType> query(ComType comtype);

  /**
   * 根据ComType插入数据方法 
   */
  int insert(ComType comtype);

  /**
   * 根据ComType插入多条数据方法 
   */
  int inserts(@Param("comtypes") List<ComType> comtypes);

  /**
   * 根据ComType条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(ComType comtype);
}