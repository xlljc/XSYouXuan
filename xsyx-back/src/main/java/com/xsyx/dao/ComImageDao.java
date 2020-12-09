package com.xsyx.dao;

import com.xsyx.vo.ComImage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface ComImageDao {



  /**
   * 查询所有方法 
   */
  List<ComImage> queryAll();

  /**
   * 根据主键id(ComImage.id)查询单条数据方法 
   */
  ComImage queryById(int id);

  /**
   * 根据ComImage条件查询多条数据方法 
   */
  List<ComImage> query(ComImage comimage);

  /**
   * 根据ComImage插入数据方法 
   */
  int insert(ComImage comimage);

  /**
   * 根据ComImage插入多条数据方法 
   */
  int inserts(@Param("comimages") List<ComImage> comimages);

  /**
   * 根据ComImage条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(ComImage comimage);
}