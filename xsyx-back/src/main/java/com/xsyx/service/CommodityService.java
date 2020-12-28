package com.xsyx.service;

import com.xsyx.vo.ComLabel;
import com.xsyx.vo.ComType;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.system.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityService{

    //条件查询 显示所有的上架商品信息
    public List<Commodity> queryCommodityAll(@Param("name") String name,
                                             @Param("state") String state, int page, int rows);
    // 根据条件查询商品记录总数量
    public PageVo<Commodity> querycountCommoditybyCond(@Param("name") String name,
                                                       @Param("state") String state, int page, int rows);

    //查询所有商品类型
    List<ComType> queryAlltype();
    //添加商品类型
    int addCommodityType(@Param("name") String name);
    //修改商品类型
    int updateCommodityType(@Param("id") String id,@Param("name") String name);

    /**
     *根据商品名 还有上架状态执行模糊查询
     */
    List<Commodity> moHuquery(@Param("name") String name,
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
    /**
     * 根据id上架商品
     */
    int up(@Param("id") String id,
           @Param("putawayDate") String putawayDate);
    //查询所有商品标签
    List<ComLabel> queryAllLabel();

}
