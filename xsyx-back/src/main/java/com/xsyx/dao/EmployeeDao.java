package com.xsyx.dao;

import com.xsyx.vo.Employee;
import com.xsyx.vo.Menu;
import com.xsyx.vo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface EmployeeDao {



  /**
   * 查询所有方法 
   */
  List<Employee> queryAll();

  /**
   * 根据主键id(Employee.id)查询单条数据方法 
   */
  Employee queryById(int id);

  /**
   * 根据Employee条件查询多条数据方法 
   */
  List<Employee> query(Employee employee);

  /**
   * 根据Employee插入数据方法 
   */
  int insert(Employee employee);

  /**
   * 根据Employee插入多条数据方法 
   */
  int inserts(@Param("employees") List<Employee> employees);

  /**
   * 根据Employee条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Employee employee);

  /**
   * 根据员工id获取该员工的所有角色
   * @param id 员工id
   */
  List<Role> queryRoles(int id);

  /**
   * 根据员工id获取该员工的所有菜单按钮
   * @param id 员工id
   */
  List<Menu> queryMenus(int id);

  /**
   * 搜索员工
   * @param str 搜索条件
   * @param sex 性别
   * @param state 状态
   * @param hasSuperAdmin 是否包含超级管理员
   * @return 员工集合
   */
  List<Employee> search(@Param("str") String str,@Param("sex") String sex,
                        @Param("state") Integer state,@Param("hasSuperAdmin") boolean hasSuperAdmin);

  /**
   * 验证密码
   */
  int validation(@Param("empId") Integer empId,@Param("password") String password);

  /**
   * 根据角色id查询拥有该角色的角色的员工
   * @return 员工集合
   */
  List<Employee> queryByRoleId(int id);
}