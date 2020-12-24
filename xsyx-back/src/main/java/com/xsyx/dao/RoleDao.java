package com.xsyx.dao;

import com.xsyx.vo.Menu;
import com.xsyx.vo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

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

  /**
   * 根据角色id查询所有拥有该角色的员工姓名
   * @param roleId 角色id
   * @return 姓名集合
   */
  List<String> queryEmpNames(int roleId);

  /**
   * 根据id删除角色
   * @param id 角色id
   */
  int delete(int id);

  /**
   * 根据Role条件模糊查询多条数据方法
   */
  List<Role> queryLike(Role role);

  List<Menu> queryMenus(Integer id);

  /**
   * 判断员工是否是超级管理员
   */
  int isSuperAdmin(int id);

  /**
   * 根据Role条件模糊查询多条数据方法
   */
  List<Role> queryHaveLike(@Param("role") Role role,@Param("empId") int empId);
}