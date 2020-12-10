package com.xsyx.controller;

import com.xsyx.utils.MyUtils;
import com.xsyx.vo.Employee;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
    public Message insert(Employee employee, HttpSession session) {
        return employeeService.insert(employee, session);
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
     * 返回当前用户信息
     *
     * @return 员工信息
     */
    @RequestMapping("/get")
    public Employee get(HttpSession session) {
        Integer id = MyUtils.getEmpId(session);
        if (id == null) return null;
        return employeeService.get(id);
    }

    /**
     * 根据姓名，性别，冻结状态，手机号等查询用户，根据id倒序排序
     *
     * @param employee  查询员工信息
     * @param pageIndex 当前分页索引
     * @param pageCount 每页显示条数
     * @return 员工集合
     */
    @RequestMapping("/query")
    public List<Employee> query(Employee employee,
                                @RequestParam(defaultValue = "0") Integer pageIndex,
                                @RequestParam(defaultValue = "15") Integer pageCount) {
        return employeeService.query(employee, pageIndex, pageCount);
    }

    /**
     * 修改员工, 参数必须包含 id
     *
     * @param employee 员工信息
     * @return 返回消息, 包含是否修改成功, 添加信息
     */
    @RequestMapping("/update")
    public Message update(Employee employee, HttpSession session) {
        return employeeService.update(employee, session);
    }

    /**
     * 根据用户id冻结一个员工,
     *
     * @param id 员工id
     * @return 返回信息, 包含是否冻结成功
     */
    @RequestMapping("/freeze")
    public Message freeze(Integer id, HttpSession session) {
        return employeeService.freeze(id, session);
    }

    /**
     * 根据员工id删除员工
     *
     * @param id 员工id
     * @return 返回信息, 包含是否删除成功
     */
    @RequestMapping("/delete")
    public Message delete(Integer id, HttpSession session) {
        return employeeService.delete(id, session);
    }

    /**
     * 员工登录, 返回登录信息, 登录储存在session中
     *
     * @param name     登录用户名
     * @param password 登录密码
     * @return 如果登录成功, 就返回true和员工信息, 如果登录失败就返回false和失败信息
     */
    @RequestMapping("/login")
    public Message login(String name, String password, HttpSession session) {
        return employeeService.login(name, password, session);
    }
}
