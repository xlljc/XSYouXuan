package com.xsyx.dao;

import com.xsyx.vo.Commodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface CommodityDao {



  /**
   * 查询所有方法 
   */
  List<Commodity> queryAll();

  /**
   * 根据主键id(Commodity.id)查询单条数据方法 
   */
  Commodity queryById(int id);

  /**
   * 根据Commodity条件查询多条数据方法 
   */
  List<Commodity> query(Commodity commodity);

  /**
   * 根据Commodity插入数据方法 
   */
  int insert(Commodity commodity);

  /**
   * 根据Commodity插入多条数据方法 
   */
  int inserts(@Param("commoditys") List<Commodity> commoditys);

  /**
   * 根据Commodity条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(Commodity commodity);
  //-----------------------
  /**
   *根据商品名 还有上架状态执行模糊查询
   */
  List<Commodity> moHuquery( @Param("name") String name,
                             @Param("state") String state);

}