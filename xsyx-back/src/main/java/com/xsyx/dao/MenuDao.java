package com.xsyx.dao;

import com.xsyx.vo.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface MenuDao {



  /**
   * 查询所有方法 
   */
  List<Menu> queryAll();

  /**
   * 根据主键id(Menu.id)查询单条数据方法 
   */
  Menu queryById(int id);

  /**
   * 根据Menu条件查询多条数据方法 
   */
  List<Menu> query(Menu menu);

  /**
   * 根据Menu插入数据方法 
   */
  int insert(Menu menu);

  /**
   * 根据Menu插入多条数据方法 
   */
  int inserts(@Param("menus") List<Menu> menus);

  /**
   * 根据Menu条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Menu menu);
}