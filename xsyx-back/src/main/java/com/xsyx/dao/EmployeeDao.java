package com.xsyx.dao;

import com.xsyx.vo.Employee;
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
}