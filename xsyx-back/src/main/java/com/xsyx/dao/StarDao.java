package com.xsyx.dao;

import com.xsyx.vo.Star;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface StarDao {



  /**
   * 查询所有方法 
   */
  List<Star> queryAll();

  /**
   * 根据主键id(Star.id)查询单条数据方法 
   */
  Star queryById(int id);

  /**
   * 根据Star条件查询多条数据方法 
   */
  List<Star> query(Star star);

  /**
   * 根据Star插入数据方法 
   */
  int insert(Star star);

  /**
   * 根据Star插入多条数据方法 
   */
  int inserts(@Param("stars") List<Star> stars);

  /**
   * 根据Star条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Star star);
}