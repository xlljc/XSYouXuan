package com.xsyx.service.impl;

import com.alibaba.fastjson.JSON;
import com.xsyx.dao.EmpLogDao;
import com.xsyx.dao.EmployeeDao;
import com.xsyx.service.EmployeeService;
import com.xsyx.utils.MyUtils;
import com.xsyx.vo.Employee;
import com.xsyx.vo.Menu;
import com.xsyx.vo.Role;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmpLogDao empLogDao;

    @Override
    public Message insert(Employee employee, HttpSession session) {
        Integer myId = MyUtils.getEmpId(session);
        //是否登录
        if (myId == null) return new Message(false, "请先登录 !");
        //先判断该用户名是否存在
        if (existName(employee.getName())) return new Message(false, "该员工名已存在!");
        //添加
        employeeDao.insert(employee);
        //写入日志
        empLogDao.addLog(myId,"添加了一个员工, 新员工id: " + employee.getId(), JSON.toJSONString(employee));
        return new Message(true, employee);
    }

    @Override
    public Employee get(Integer id) {
        return employeeDao.queryById(id);
    }

    @Override
    public List<Employee> query(Employee employee, Integer pageIndex, Integer pageCount) {
        return null;
    }

    @Override
    public Message update(Employee employee, HttpSession session) {
        Integer myId = MyUtils.getEmpId(session);
        //是否登录
        if (myId == null) return new Message(false, "请先登录 !");
        //先判断该用户名是否存在
        if (existName(employee.getName())) return new Message(false, "该员工名已存在!");
        employeeDao.updateById(employee);
        //写入日志
        empLogDao.addLog(myId,"修改一个员工的信息, 被修改员工id: " + employee.getId(),JSON.toJSONString(employee));
        return new Message(true,"修改成功!");
    }

    @Override
    public Message freeze(Integer id, HttpSession session) {
        Integer myId = MyUtils.getEmpId(session);
        //是否登录
        if (myId == null) return new Message(false, "请先登录 !");
        Employee employee = new Employee();
        employee.setId(id);
        employee.setState(0);
        if (employeeDao.updateById(employee) > 0) {
            //写入日志
            empLogDao.addLog(myId,"冻结一个员工, 被冻结员工id: " + id,JSON.toJSONString(employee));
            return new Message(true,"修改成功!");
        }
        return new Message(false,"修改失败!");
    }

    @Override
    public Message delete(Integer id, HttpSession session) {
        Integer myId = MyUtils.getEmpId(session);
        //是否登录
        if (myId == null) return new Message(false, "请先登录 !");
        Employee employee = new Employee();
        employee.setId(id);
        employee.setState(-1);
        if (employeeDao.updateById(employee) > 0) {
            //写入日志
            empLogDao.addLog(myId,"删除一个员工, 被删除员工id: " + id,JSON.toJSONString(employee));
            return new Message(true,"删除成功!");
        }
        return new Message(false,"删除失败!");
    }

    @Override
    public Message login(String name, String password, HttpSession session) {
        if (name == null || password == null) return new Message(false,"登录失败! 用户名或密码错误!");
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPassword(password);
        //登录查询
        List<Employee> emps = employeeDao.query(employee);
        if (emps.size() > 0){
            Employee employee1 = emps.get(0);
            //修改最后登录日期
            Employee employee2 = new Employee();
            employee2.setId(employee1.getId());
            employee2.setLastLoginTime(new Timestamp(new Date().getTime()));
            employeeDao.updateById(employee2);
            //设置session
            MyUtils.setEmpId(employee1.getId(),session);
            //写入日志
            empLogDao.addLog(employee1.getId(),"登录系统",null);
            return new Message(true,"登录成功! ");
        }
        return new Message(false,"登录失败! 用户名或密码错误!");
    }

    @Override
    public List<Role> queryRoles(Integer id) {
        return employeeDao.queryRoles(id);
    }

    @Override
    public List<Menu> queryMenus(Integer id) {
        List<Menu> menus = new ArrayList<>();
        List<Menu> ms = employeeDao.queryMenus(id);
        for (Menu btn : ms) {
            //页面级
            Menu page = btn.getParent();
            //模块级
            Menu menu = page.getParent();

            int index = indexOfId(menus,menu);
            if (index == -1) {
                menu.setMenus(new ArrayList<Menu>());
                menus.add(menu);
            } else menu = menus.get(index);

            List<Menu> menuPages = menu.getMenus();
            index = indexOfId(menuPages,page);
            if (index == -1) {
                page.setMenus(new ArrayList<Menu>());
                page.setParent(null);
                menuPages.add(page);
            } else page = menuPages.get(index);
            btn.setParent(null);
            page.getMenus().add(btn);
        }
        return menus;
    }















    /**
     * 查找在集合中查找索引, 比较id值
     * @param menus 菜单集合
     * @param menu 菜单对象
     * @return index or -1
     */
    private int indexOfId(List<Menu> menus,Menu menu) {
        if (menu.getId() == null) return -1;
        int length = menus.size();
        for (int i = 0; i < length; i++)
            if (menu.getId().equals(menus.get(i).getId())) return i;
        return -1;
    }

    /**
     * 判断该用户名是否存在
     * @param name 用户名
     * @return bool
     */
    private boolean existName(String name) {
        Employee employee = new Employee();
        employee.setName(name == null ? "" : name);
        return employeeDao.query(employee).size() > 0;
    }
}
