package com.xsyx.dao;

import com.xsyx.vo.Shopcar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface ShopcarDao {



  /**
   * 查询所有方法 
   */
  List<Shopcar> queryAll();

  /**
   * 根据主键id(Shopcar.id)查询单条数据方法 
   */
  Shopcar queryById(int id);

  /**
   * 根据Shopcar条件查询多条数据方法 
   */
  List<Shopcar> query(Shopcar shopcar);

  /**
   * 根据Shopcar插入数据方法 
   */
  int insert(Shopcar shopcar);

  /**
   * 根据Shopcar插入多条数据方法 
   */
  int inserts(@Param("shopcars") List<Shopcar> shopcars);

  /**
   * 根据Shopcar条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Shopcar shopcar);

  List<Shopcar> queryShopcarByuid(Integer uid);

  /*
   *删除购物车
   */
  int delShopcar(@Param("id") int id);


}