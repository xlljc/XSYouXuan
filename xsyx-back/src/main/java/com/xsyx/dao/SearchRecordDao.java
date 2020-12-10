package com.xsyx.dao;

import com.xsyx.vo.SearchRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface SearchRecordDao {



  /**
   * 查询所有方法 
   */
  List<SearchRecord> queryAll();

  /**
   * 根据主键id(SearchRecord.id)查询单条数据方法 
   */
  SearchRecord queryById(int id);

  /**
   * 根据SearchRecord条件查询多条数据方法 
   */
  List<SearchRecord> query(SearchRecord searchrecord);

  /**
   * 根据SearchRecord插入数据方法 
   */
  int insert(SearchRecord searchrecord);

  /**
   * 根据SearchRecord插入多条数据方法 
   */
  int inserts(@Param("searchrecords") List<SearchRecord> searchrecords);

  /**
   * 根据SearchRecord条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(SearchRecord searchrecord);
}