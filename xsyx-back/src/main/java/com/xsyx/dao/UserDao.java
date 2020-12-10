package com.xsyx.dao;

import com.xsyx.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface UserDao {



  /**
   * 查询所有方法 
   */
  List<User> queryAll();

  /**
   * 根据主键id(User.id)查询单条数据方法 
   */
  User queryById(int id);

  /**
   * 根据User条件查询多条数据方法 
   */
  List<User> query(User user);

  /**
   * 根据User插入数据方法 
   */
  int insert(User user);

  /**
   * 根据User插入多条数据方法 
   */
  int inserts(@Param("users") List<User> users);

  /**
   * 根据User条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(User user);
}