package com.xsyx.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsyx.dao.EmpLogDao;
import com.xsyx.dao.MerchantsApplyDao;
import com.xsyx.dao.MerchantsDao;
import com.xsyx.dao.UserDao;
import com.xsyx.service.MerchantsService;
import com.xsyx.vo.Merchants;
import com.xsyx.vo.MerchantsApply;
import com.xsyx.vo.User;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantsServiceImpl implements MerchantsService {

    @Autowired
    private MerchantsDao merchantsDao;

    @Autowired
    private EmpLogDao empLogDao;

    @Autowired
    private MerchantsApplyDao merchantsApplyDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Message insert(Merchants merchants) {
        Message message = new Message(true, merchants);
        merchants.getId();
        merchantsDao.insert(merchants);

        return message;
    }
    @Override
    public PageInfo<Merchants> query(String str, Integer page, Integer row) {
        PageHelper.startPage(page, row);
        return new PageInfo<>(merchantsDao.queryBy(str));
    }

    @Override
    public Message delete(Integer merId, Integer empId) {
        if (empId == null) return new Message(false, "请先登录 !");
        System.out.println("merId : " + merId);
        //先把用户解绑
        userDao.unMerchant(merId);
        Merchants merchants = new Merchants();
        merchants.setId(merId);
        merchants.setState(-1);
        if (merchantsDao.updateById(merchants) > 0) {
            empLogDao.addLog(empId, "删除商户: id = " + merId, "{\"merId\": \"" + merId + "\"}");
        }
        return new Message(true, "操作成功 !");
    }

    @Override
    public Message update(Merchants merchants, Integer empId) {
        if (empId == null) return new Message(false, "请先登录 !");
        if (merchantsDao.updateById(merchants) > 0) {
            empLogDao.addLog(empId, "修改商户: id = " + merchants.getId(), JSON.toJSONString(merchants));
        }
        return new Message(true, "修改成功");
    }

    @Override
    public PageInfo<MerchantsApply> queryApply(String str, Integer page, Integer row) {
        PageHelper.startPage(page,row);
        return new PageInfo<>(merchantsApplyDao.queryApply(str));
    }

    @Override
    public Message approval(Integer id, Boolean flag, String message, Integer empId) {
        System.out.println(id+","+flag+","+message+","+empId);
        if (empId == null) return new Message(false, "请先登录 !");
        System.out.println(merchantsApplyDao.queryById(id));
        MerchantsApply merchantsApply = new MerchantsApply();
        merchantsApply.setId(id);
        merchantsApply.setIsRead(1);
        merchantsApply.setSystemMessage(message);
        if (flag) { //通过
            merchantsApply.setState(1);
            merchantsApplyDao.updateById(merchantsApply);
            //获取申请信息
            MerchantsApply apply = merchantsApplyDao.queryById(id);
            //创建商户信息
            Merchants merchants = new Merchants();
            merchants.setName(apply.getName());
            merchants.setAddress(apply.getAddress());
            merchants.setPhone(apply.getUserId().getPhone());
            merchants.setRemark(apply.getUserMessage());
            merchantsDao.insert(merchants);
            //绑定信息
            User user = new User();
            user.setId(apply.getUserId().getId());
            user.setMerid(merchants);
            userDao.updateById(user);
            //写入日志
            empLogDao.addLog(empId, "通过商户申请: id = " + id, JSON.toJSONString(merchantsApply));
        } else { //失败
            merchantsApply.setState(-1);
            System.out.println("拒绝: " + merchantsApply);
            merchantsApplyDao.updateById(merchantsApply);
            //写入日志
            empLogDao.addLog(empId, "拒绝商户申请: id = " + id, JSON.toJSONString(merchantsApply));
        }
        return new Message(true, "提交成功 !");
    }

    @Override
    public List<Merchants> queryAll() {
        return merchantsDao.queryAll();
    }
}
