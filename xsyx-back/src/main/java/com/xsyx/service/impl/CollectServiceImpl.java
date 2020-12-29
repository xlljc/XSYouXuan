package com.xsyx.service.impl;

import com.xsyx.dao.CollectDao;
import com.xsyx.service.CollectService;
import com.xsyx.vo.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectDao collectDao;


    @Override
    public List<Collect> queryAll() {
        return collectDao.queryAll();
    }

    @Override
    public int insert(Collect collect) {
        return collectDao.insert(collect);
    }
}
