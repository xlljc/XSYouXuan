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
            Class<?> stuCla = obj.getClass();
            Field[] fs = stuCla.getDeclaredFields();
            for (Field f : fs) {
                f.setAccessible(true);
                Object val = f.get(obj);
                if (val != null) {
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
