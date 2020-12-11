package com.xsyx.dao;

import com.xsyx.vo.UserLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface UserLogDao {



  /**
   * 查询所有方法 
   */
  List<UserLog> queryAll();

  /**
   * 根据主键id(UserLog.id)查询单条数据方法 
   */
  UserLog queryById(int id);

  /**
   * 根据UserLog条件查询多条数据方法 
   */
  List<UserLog> query(UserLog userlog);

  /**
   * 根据UserLog插入数据方法 
   */
  int insert(UserLog userlog);

  /**
   * 根据UserLog插入多条数据方法 
   */
  int inserts(@Param("userlogs") List<UserLog> userlogs);

  /**
   * 根据UserLog条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(UserLog userlog);


  /**
   * 添加一篇用户操作日志
   * @param userId 用户id
   * @param content 内容
   * @param data 附加数据, 没有就填null
   */
  int addLog(@Param("userId") Integer userId,@Param("content") String content,@Param("data") String data);

}