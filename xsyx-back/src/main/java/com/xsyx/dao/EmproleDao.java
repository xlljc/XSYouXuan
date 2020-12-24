package com.xsyx.dao;

import com.xsyx.vo.Emprole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface EmproleDao {



  /**
   * 查询所有方法 
   */
  List<Emprole> queryAll();

  /**
   * 根据主键id(Emprole.id)查询单条数据方法 
   */
  Emprole queryById(int id);

  /**
   * 根据Emprole条件查询多条数据方法 
   */
  List<Emprole> query(Emprole emprole);

  /**
   * 根据Emprole插入数据方法 
   */
  int insert(Emprole emprole);

  /**
   * 根据Emprole插入多条数据方法 
   */
  int inserts(@Param("emproles") List<Emprole> emproles);

  /**
   * 根据Emprole条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Emprole emprole);

  /**
   * 根据id删除多条数据
   */
  int deletes(@Param("empId") int empId);
}