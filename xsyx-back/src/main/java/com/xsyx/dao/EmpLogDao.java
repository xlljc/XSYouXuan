package com.xsyx.dao;

import com.xsyx.vo.EmpLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface EmpLogDao {



  /**
   * 查询所有方法 
   */
  List<EmpLog> queryAll();

  /**
   * 根据主键id(EmpLog.id)查询单条数据方法 
   */
  EmpLog queryById(int id);

  /**
   * 根据EmpLog条件查询多条数据方法 
   */
  List<EmpLog> query(EmpLog emplog);

  /**
   * 根据EmpLog插入数据方法 
   */
  int insert(EmpLog emplog);

  /**
   * 根据EmpLog插入多条数据方法 
   */
  int inserts(@Param("emplogs") List<EmpLog> emplogs);

  /**
   * 根据EmpLog条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(EmpLog emplog);

  /**
   * 添加一篇员工操作日志
   * @param empId 员工id
   * @param content 内容
   * @param data 附加数据, 没有就填null
   */
  int addLog(@Param("empId") Integer empId,@Param("content") String content,@Param("data") String data);
}