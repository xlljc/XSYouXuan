package com.xsyx.service;

import com.github.pagehelper.PageInfo;
import com.xsyx.vo.Employee;
import com.xsyx.vo.Menu;
import com.xsyx.vo.Role;
import com.xsyx.vo.system.Message;

import java.util.List;

public interface EmployeeService {

    Message insert(Employee employee, Integer empId);

    Employee get(Integer id);


    Message update(Employee employee, Integer empId);

    Message freeze(Integer id, Integer empId);

    Message delete(Integer id, Integer empId);

    Message login(String name, String password);

    List<Role> queryRoles(Integer id);

    List<Menu> queryMenus(Integer id);

    PageInfo<Employee> query(String name, String sex, Integer state, Integer page, Integer row);
}
