package com.xsyx.service;

import com.xsyx.vo.Collect;

import java.util.List;

public interface CollectService {
    /**
     * 根据Collect条件查询多条数据方法
     */
    List<Collect> queryAll();

    /**
     * 根据Collect插入数据方法
     */
    int insert(Collect collect);
}
