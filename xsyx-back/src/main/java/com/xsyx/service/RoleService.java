package com.xsyx.service;

import com.github.pagehelper.PageInfo;
import com.xsyx.vo.Role;
import com.xsyx.vo.system.Message;

public interface RoleService {

    Message insert(Role role, Integer empId);

    PageInfo<Role> query(Role role,int page,int row);

    Message update(Role role, Integer empId);

    Message delete(int id, Integer empId);

}
