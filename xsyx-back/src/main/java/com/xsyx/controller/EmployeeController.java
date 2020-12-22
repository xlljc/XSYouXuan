package com.xsyx.controller;


import com.github.pagehelper.PageInfo;
import com.xsyx.vo.Employee;
import com.xsyx.vo.Menu;
import com.xsyx.vo.Role;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.xsyx.service.EmployeeService;

/**
 * 员工控制层
 * @author 李锦程
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * 添加员工
     *
     * @param employee 员工信息
     * @return 返回消息, 包含是否添加成功, 添加信息
     */
    @RequestMapping("/insert")
    public Message insert(Employee employee, Integer empId) {
        
        return employeeService.insert(employee, empId);
    }

    /**
     * 根据员工id查询员工
     *
     * @param id id值
     * @return 员工信息
     */
    @RequestMapping("/get/{id}")
    public Employee get(@PathVariable Integer id) {
        return employeeService.get(id);
    }

    /**
     * 根据姓名，性别，冻结状态，手机号等查询用户，根据id倒序排序
     *
     * @param page 当前分页索引
     * @param row 每页显示条数
     * @return 员工集合
     */
    @RequestMapping("/query")
    public PageInfo<Employee> query(String name,String sex,Integer state,
                                    @RequestParam(value = "page",defaultValue = "0") Integer page,
                                    @RequestParam(value = "row",defaultValue = "15") Integer row) {
        return employeeService.query(name,sex,state, page, row);
    }

    /**
     * 修改员工, 参数必须包含 id
     *
     * @param employee 员工信息
     * @return 返回消息, 包含是否修改成功, 添加信息
     */
    @RequestMapping("/update")
    public Message update(Employee employee, Integer empId) {
        return employeeService.update(employee, empId);
    }

    /**
     * 根据用户id冻结一个员工,
     *
     * @param id 员工id
     * @return 返回信息, 包含是否冻结成功
     */
    @RequestMapping("/freeze")
    public Message freeze(Integer id, Integer empId) {
        return employeeService.freeze(id, empId);
    }

    /**
     * 根据员工id删除员工
     *
     * @param id 员工id
     * @return 返回信息, 包含是否删除成功
     */
    @RequestMapping("/delete")
    public Message delete(Integer id, Integer empId) {

        return employeeService.delete(id, empId);
    }

    /**
     * 员工登录, 返回登录信息, 登录储存在empId中
     *
     * @param name     登录用户名
     * @param password 登录密码
     * @return 如果登录成功, 就返回true和员工信息, 如果登录失败就返回false和失败信息
     */
    @RequestMapping("/login")
    public Message login(String name, String password) {
        return employeeService.login(name, password);
    }

    /**
     * 根据员工id获取该员工所有角色, 如果没有传id值, 就从empId中获取
     *
     * @param id 员工id
     */
    @RequestMapping("/queryRoles")
    public List<Role> queryRoles(Integer id) {
        if (id == null) return null;
        return employeeService.queryRoles(id);
    }

    /**
     * 根据员工id获取该员工所有菜单, 如果没有传id值, 就从empId中获取
     *
     * @param id 员工id
     */
    @RequestMapping("/queryMenus")
    public List<Menu> queryMenus(Integer id) {
        if (id == null) return null;
        return employeeService.queryMenus(id);
    }

}
