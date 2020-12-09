package com.xsyx.dao;

import com.xsyx.vo.ComLabel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface ComLabelDao {



  /**
   * 查询所有方法 
   */
  List<ComLabel> queryAll();

  /**
   * 根据主键id(ComLabel.id)查询单条数据方法 
   */
  ComLabel queryById(int id);

  /**
   * 根据ComLabel条件查询多条数据方法 
   */
  List<ComLabel> query(ComLabel comlabel);

  /**
   * 根据ComLabel插入数据方法 
   */
  int insert(ComLabel comlabel);

  /**
   * 根据ComLabel插入多条数据方法 
   */
  int inserts(@Param("comlabels") List<ComLabel> comlabels);

  /**
   * 根据ComLabel条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(ComLabel comlabel);
}