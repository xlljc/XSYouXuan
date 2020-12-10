package com.xsyx.dao;

import com.xsyx.vo.LookHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface LookHistoryDao {



  /**
   * 查询所有方法 
   */
  List<LookHistory> queryAll();

  /**
   * 根据主键id(LookHistory.id)查询单条数据方法 
   */
  LookHistory queryById(int id);

  /**
   * 根据LookHistory条件查询多条数据方法 
   */
  List<LookHistory> query(LookHistory lookhistory);

  /**
   * 根据LookHistory插入数据方法 
   */
  int insert(LookHistory lookhistory);

  /**
   * 根据LookHistory插入多条数据方法 
   */
  int inserts(@Param("lookhistorys") List<LookHistory> lookhistorys);

  /**
   * 根据LookHistory条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(LookHistory lookhistory);
}