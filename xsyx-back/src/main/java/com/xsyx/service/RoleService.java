package com.xsyx.service;

import com.github.pagehelper.PageInfo;
import com.xsyx.vo.Menu;
import com.xsyx.vo.Role;
import com.xsyx.vo.system.Message;

import java.util.List;

public interface RoleService {

    Message insert(Role role, Integer empId);

    PageInfo<Role> query(Role role,int page,int row);

    Message update(Role role, Integer empId);

    Message delete(int id, Integer empId);

    List<Menu> queryMenus(Integer id);

    Message roleService(List<Integer> addIds, List<Integer> removeIds,Integer roleId, Integer empId);

    PageInfo<Role> queryHaveRole(Role role,Integer empId, int page, int row);
}
