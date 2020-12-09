package com.xsyx.dao;

import com.xsyx.vo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface RoleDao {



  /**
   * 查询所有方法 
   */
  List<Role> queryAll();

  /**
   * 根据主键id(Role.id)查询单条数据方法 
   */
  Role queryById(int id);

  /**
   * 根据Role条件查询多条数据方法 
   */
  List<Role> query(Role role);

  /**
   * 根据Role插入数据方法 
   */
  int insert(Role role);

  /**
   * 根据Role插入多条数据方法 
   */
  int inserts(@Param("roles") List<Role> roles);

  /**
   * 根据Role条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Role role);
}