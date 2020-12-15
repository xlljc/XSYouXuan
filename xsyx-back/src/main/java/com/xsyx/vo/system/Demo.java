package com.xsyx.vo.system;

import com.xsyx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class Demo extends Thread {

    private static Demo instance = null;

    public static Demo getActionInstance(){
        if (instance == null) instance = new Demo();
        return instance;
    }

    @Autowired
    private UserDao userDao;

    /**
     * 创建实例线程
     */
    public Demo() {
        // 先检查之前是否启用过线程, 确保只有一个执行的实例
        if (instance != null) instance.flag = false;
        instance = this;

        System.out.println("创建Demo实例!");
        start();
    }

    /**
     * 线程是否继续执行下去
     */
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                // 线程暂停60s
                Thread.sleep(10000);
                // 如果被结束线程, 则不继续进行下去
                if (!flag) return;




                //System.out.println("userDao : " + userDao.queryAll());

            } catch (Exception e) {
                flag = false;
                e.printStackTrace();
            }
        }
    }
}
