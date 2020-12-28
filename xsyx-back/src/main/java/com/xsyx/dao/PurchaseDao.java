package com.xsyx.dao;

import com.xsyx.vo.Purchase;
import com.xsyx.vo.PurchaseLinShi;
import com.xsyx.vo.Purchaseorder;
import com.xsyx.vo.Warehouse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


//采购Dao
@Repository
public interface PurchaseDao {

    //查询所有临时采购表的数据
    List<PurchaseLinShi> PurchaseLinShiAll();

    //根据商品id 和 采购数量 向临时采购表添加数据
    int addLinShiPurchase(@Param("commodityid") String commodityid,
                          @Param("caigousum") String caigousum);
    //根据商品id 查询临时采购表是否有这个商品
    int queryPurchaseLinShiBycommodityid(@Param("commodityid") String commodityid);
    //根据商品id 添加数量
    int updatePurchaseLinShicommoditysum(@Param("commodityid") String commodityid,
                                         @Param("caigousum") String caigousum);
    //清除所有临时采购表的数据
    int deletePurchaseLinShi();

    //生成订单详情表 未审核记录
    int addPurchaseOrder(@Param("applicant") String applicant,
                          @Param("applicantremarks") String applicantremarks);
    //查询订单详情表的最大订单号
    int queryorderidBig();
    //添加采购表数据
    int addPurchase(@Param("orderid") int orderid,
                    @Param("commodityid") String commodityid,
                    @Param("commoditysum") String commoditysum);

    //审核部分-------------
    //查询所有未审核订单信息
    List<Purchaseorder> querypurchaseorderAll();
    //根据订单id 查询所有采购商品
    List<Purchase> querycaigouAll(@Param("orderid") String orderid);
    //查询所有不是未审核订单信息
    List<Purchaseorder> purchaseorderAllnowei();
    //完成审核修改订单状态
    int updatepurchaseorder(@Param("orderid") int orderid,
                            @Param("approvedby") String approvedby,
                            @Param("state") String state, 
                            @Param("approvedbyremarks") String approvedbyremarks);
}
