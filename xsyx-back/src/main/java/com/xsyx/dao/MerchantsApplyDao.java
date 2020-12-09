package com.xsyx.dao;

import com.xsyx.vo.MerchantsApply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface MerchantsApplyDao {



  /**
   * 查询所有方法 
   */
  List<MerchantsApply> queryAll();

  /**
   * 根据主键id(MerchantsApply.id)查询单条数据方法 
   */
  MerchantsApply queryById(int id);

  /**
   * 根据MerchantsApply条件查询多条数据方法 
   */
  List<MerchantsApply> query(MerchantsApply merchantsapply);

  /**
   * 根据MerchantsApply插入数据方法 
   */
  int insert(MerchantsApply merchantsapply);

  /**
   * 根据MerchantsApply插入多条数据方法 
   */
  int inserts(@Param("merchantsapplys") List<MerchantsApply> merchantsapplys);

  /**
   * 根据MerchantsApply条件修改单条数据方法,从传入对象获取id 
   */
  int updateById(MerchantsApply merchantsapply);
}