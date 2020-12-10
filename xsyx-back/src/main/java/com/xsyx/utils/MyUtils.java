package com.xsyx.utils;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;

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
     * 通过session获取用户id
     * @param session session对象
     * @return 返回用户id , 如果没有, 就返回null
     */
    public static Integer getUserId(HttpSession session) {
        Object o = session.getAttribute("userId");
        return o == null ? null : (Integer) o;
    }

    /**
     * 通过session设置用户id
     * @param id id
     * @param session session对象
     */
    public static void setUserId(int id,HttpSession session) {
        session.setAttribute("userId",id);
    }

    /**
     * 通过session获取员工id
     * @param session session对象
     * @return 返回用户id , 如果没有, 就返回null
     */
    public static Integer getEmpId(HttpSession session) {
        Object o = session.getAttribute("empId");
        return o == null ? null : (Integer) o;
    }

    /**
     * 通过session设置员工id
     * @param id id
     * @param session session对象
     */
    public static void setEmpId(int id,HttpSession session) {
        session.setAttribute("empId",id);
    }

}
