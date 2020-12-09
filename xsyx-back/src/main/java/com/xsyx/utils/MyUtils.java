package com.xsyx.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MyUtils {

    /**
     * 判断对象属性是否全为空
     * @param obj 对象
     * @return bool
     */
    public static boolean isAllFieldNull(Object obj) {
        try {
            Class<?> stuCla = obj.getClass();// 得到类对象
            Field[] fs = stuCla.getDeclaredFields();//得到属性集合
            for (Field f : fs) {//遍历属性
                f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
                Object val = f.get(obj);// 得到此属性的值
                if (val != null) {//只要有1个属性不为空,那么就不是所有的属性值都为空
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 给controller返回的map添加数据
     */
    public static Map<String ,Object> mapSetMsg(boolean flag,String msg){
        Map<String ,Object> map = new HashMap<>();
        map.put("msg",msg);
        map.put("flag",flag);
        return map;
    }
}
