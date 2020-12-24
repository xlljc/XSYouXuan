package com.xsyx.service;



import com.xsyx.vo.PurchaseLinShi;
import com.xsyx.vo.Purchaseorder;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface PurchaseService {

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


    //查询所有未审核订单信息
    List<Purchaseorder> querypurchaseorderAll();
   
}
