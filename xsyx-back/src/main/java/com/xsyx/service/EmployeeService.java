package com.xsyx.service;

import com.xsyx.vo.Employee;
import com.xsyx.vo.Menu;
import com.xsyx.vo.Role;
import com.xsyx.vo.system.Message;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface EmployeeService {

    Message insert(Employee employee, HttpSession session);

    Employee get(Integer id);

    List<Employee> query(Employee employee, Integer pageIndex, Integer pageCount);

    Message update(Employee employee, HttpSession session);

    Message freeze(Integer id, HttpSession session);

    Message delete(Integer id, HttpSession session);

    Message login(String name, String password, HttpSession session);

    List<Role> queryRoles(Integer id);

    List<Menu> queryMenus(Integer id);
}
