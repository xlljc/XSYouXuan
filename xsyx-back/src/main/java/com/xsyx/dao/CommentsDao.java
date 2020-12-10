package com.xsyx.dao;

import com.xsyx.vo.Comments;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface CommentsDao {



  /**
   * 查询所有方法 
   */
  List<Comments> queryAll();

  /**
   * 根据主键id(Comments.id)查询单条数据方法 
   */
  Comments queryById(int id);

  /**
   * 根据Comments条件查询多条数据方法 
   */
  List<Comments> query(Comments comments);

  /**
   * 根据Comments插入数据方法 
   */
  int insert(Comments comments);

  /**
   * 根据Comments插入多条数据方法 
   */
  int inserts(@Param("commentss") List<Comments> commentss);

  /**
   * 根据Comments条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Comments comments);
}