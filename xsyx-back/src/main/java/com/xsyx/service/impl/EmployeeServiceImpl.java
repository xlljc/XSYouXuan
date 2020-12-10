package com.xsyx.service.impl;

import com.xsyx.dao.EmployeeDao;
import com.xsyx.service.EmployeeService;
import com.xsyx.utils.MyUtils;
import com.xsyx.vo.Employee;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Message insert(Employee employee, HttpSession session) {
        //是否登录
        if (MyUtils.getEmpId(session) == null) {
            return new Message(false,"请先登录 !");
        }
        //先判断该用户名是否存在
        Employee employee1 = new Employee();
        employee1.setName(employee.getName());
        if (employeeDao.query(employee1).size() > 0) {
            return new Message(false,"该员工名已存在!");
        }
        //
        return null;
    }

    @Override
    public Employee get(Integer id) {
        return null;
    }

    @Override
    public List<Employee> query(Employee employee, Integer pageIndex, Integer pageCount) {
        return null;
    }

    @Override
    public Message update(Employee employee, HttpSession session) {
        return null;
    }

    @Override
    public Message freeze(Integer id, HttpSession session) {
        return null;
    }

    @Override
    public Message delete(Integer id, HttpSession session) {
        return null;
    }

    @Override
    public Message login(String name, String password, HttpSession session) {
        return null;
    }
}
