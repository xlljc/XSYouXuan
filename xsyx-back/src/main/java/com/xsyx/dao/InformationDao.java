package com.xsyx.dao;

import com.xsyx.vo.Information;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface InformationDao {



  /**
   * 查询所有方法 
   */
  List<Information> queryAll();

  /**
   * 根据主键id(Information.id)查询单条数据方法 
   */
  Information queryById(int id);

  /**
   * 根据Information条件查询多条数据方法 
   */
  List<Information> query(Information information);

  /**
   * 根据Information插入数据方法 
   */
  int insert(Information information);

  /**
   * 根据Information插入多条数据方法 
   */
  int inserts(@Param("informations") List<Information> informations);

  /**
   * 根据Information条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Information information);
}