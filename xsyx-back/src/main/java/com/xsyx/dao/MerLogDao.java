package com.xsyx.dao;

import com.xsyx.vo.MerLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface MerLogDao {



  /**
   * 查询所有方法 
   */
  List<MerLog> queryAll();

  /**
   * 根据主键id(MerLog.id)查询单条数据方法 
   */
  MerLog queryById(int id);

  /**
   * 根据MerLog条件查询多条数据方法 
   */
  List<MerLog> query(MerLog merlog);

  /**
   * 根据MerLog插入数据方法 
   */
  int insert(MerLog merlog);

  /**
   * 根据MerLog插入多条数据方法 
   */
  int inserts(@Param("merlogs") List<MerLog> merlogs);

  /**
   * 根据MerLog条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(MerLog merlog);
}