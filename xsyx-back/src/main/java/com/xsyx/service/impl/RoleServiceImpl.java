package com.xsyx.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsyx.dao.EmpLogDao;
import com.xsyx.dao.RoleDao;
import com.xsyx.service.RoleService;
import com.xsyx.utils.MyUtils;
import com.xsyx.vo.Role;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private EmpLogDao empLogDao;

    @Override
    public Message insert(Role role, Integer empId) {
        if (empId == null) return new Message(false,"请先登录!");
        if (roleDao.insert(role) > 0) {
            empLogDao.addLog(empId,"添加角色 : id=" + role.getId(), JSON.toJSONString(role));
            return new Message(true,"添加成功!");
        }
        return new Message(false,"添加失败!");
    }

    @Override
    public PageInfo<Role> query(Role role, int page, int row) {
        PageHelper.startPage(page,page);
        return new PageInfo<>(roleDao.query(role));
    }

    @Override
    public Message update(Role role, Integer empId) {
        if (empId == null) return new Message(false,"请先登录!");
        if (roleDao.updateById(role) > 0) {
            empLogDao.addLog(empId,"修改角色 : id=" + role.getId(), JSON.toJSONString(role));
            return new Message(true,"修改成功!");
        }
        return new Message(false,"修改失败!");
    }

    @Override
    public Message delete(int id, Integer empId) {
        if (empId == null) return new Message(false, "请先登录!");
        //如果是超级管理员
        if (id == 1) return new Message(false, "你没有权限删除超级管理员!");
        //先查询是否有包含该角色的员工
        List<String> empNames = roleDao.queryEmpNames(id);
        if (empNames.size() > 0) {
            String names = MyUtils.listJoin(empNames, ",", "", "");
            return new Message(false, "删除失败! 员工 : " + names + " 已含有该角色, 无法删除!");
        }
        //执行删除操作
        Role role = roleDao.queryById(id);
        if (role != null) {
            empLogDao.addLog(empId, "删除角色: " + role.getName(), JSON.toJSONString(role));
            roleDao.delete(id);
        }
        return new Message(true, "删除成功!");
    }
}
