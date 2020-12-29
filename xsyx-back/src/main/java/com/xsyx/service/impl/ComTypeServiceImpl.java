package com.xsyx.service.impl;

import com.xsyx.dao.ComTypeDao;
import com.xsyx.service.ComTypeService;
import com.xsyx.vo.ComType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComTypeServiceImpl implements ComTypeService {

    @Autowired
    private ComTypeDao comTypeDao;

    @Override
    public List<ComType> queryHot() {
        return comTypeDao.queryHot();
    }
}
