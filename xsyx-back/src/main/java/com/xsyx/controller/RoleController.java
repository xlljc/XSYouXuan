package com.xsyx.controller;

import com.github.pagehelper.PageInfo;
import com.xsyx.service.RoleService;
import com.xsyx.vo.Role;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色控制层
 * @author 李锦程
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 添加角色
     *
     * @param role  角色属性
     * @param empId 操作员id, 用于日志生成
     * @return 是否成功
     */
    @RequestMapping("/insert")
    public Message insert(Role role, Integer empId) {
        return roleService.insert(role,empId);
    }

    /**
     * 查询角色, 代码分页
     * @param role 查询的信息
     * @return 分页对象
     */
    @RequestMapping("/query")
    public PageInfo<Role> query(Role role,
                                @RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "row", defaultValue = "10") int row) {
        return roleService.query(role,page,row);
    }

    /**
     * 修改角色
     *
     * @param role  角色信息
     * @param empId 操作员id, 用于日志生成
     * @return 是否成功
     */
    @RequestMapping("/update")
    public Message update(Role role, Integer empId) {
        return roleService.update(role,empId);
    }

    /**
     * 删除角色, 如果有员工有该角色, 是不能删除的
     *
     * @param id    角色id
     * @param empId 操作员id, 用于日志生成
     * @return 是否删除成功
     */
    @RequestMapping("/delete")
    public Message delete(Integer id, Integer empId) {
        return roleService.delete(id,empId);
    }
}
