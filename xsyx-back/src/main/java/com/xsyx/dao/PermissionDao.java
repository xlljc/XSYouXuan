package com.xsyx.dao;

import com.xsyx.vo.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface PermissionDao {



  /**
   * 查询所有方法 
   */
  List<Permission> queryAll();

  /**
   * 根据主键id(Permission.id)查询单条数据方法 
   */
  Permission queryById(int id);

  /**
   * 根据Permission条件查询多条数据方法 
   */
  List<Permission> query(Permission permission);

  /**
   * 根据Permission插入数据方法 
   */
  int insert(Permission permission);

  /**
   * 根据Permission插入多条数据方法 
   */
  int inserts(@Param("permissions") List<Permission> permissions);

  /**
   * 根据Permission条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Permission permission);
}