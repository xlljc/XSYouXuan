package com.xsyx.dao;

import com.xsyx.vo.ComLabel;
import com.xsyx.vo.ComType;
import com.xsyx.vo.Commodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface CommodityDao {

  //条件查询 显示所有的上架商品信息
  List<Commodity> queryCommodityAll(@Param("name") String name,
                                    @Param("state") String state);
  // 根据条件查询商品记录总数量
  int querycountCommoditybyCond(@Param("name") String name,
                                @Param("state") String state);


  /**
   *根据商品名 还有上架状态执行模糊查询
   */
  List<Commodity> moHuquery( @Param("name") String name,
                             @Param("state") String state);


  /**
   *添加商品
   */
  int addCommodity(@Param("name") String name,
              @Param("particulars") String particulars,
              @Param("image") String image,
              @Param("price") String price,
              @Param("unit") String unit,
              @Param("specification") String specification,
              @Param("manufacturer") String manufacturer,
              @Param("type") String type);
  /**
   * 修改商品
   * 
   */
  int updateCommodity(@Param("name") String name,
                   @Param("particulars") String particulars,
                   @Param("image") String image,
                   @Param("price") String price,
                   @Param("unit") String unit,
                   @Param("specification") String specification,
                   @Param("manufacturer") String manufacturer,
                   @Param("type") String type, 
                      @Param("id") String id);

  /**
   * 根据id下架商品
   */
  int deleteCommodity(@Param("id") String id);

  //查询所有商品类型
  List<ComType> queryAlltype();
  
  //查询所有商品标签
  List<ComLabel> queryAllLabel();
}
