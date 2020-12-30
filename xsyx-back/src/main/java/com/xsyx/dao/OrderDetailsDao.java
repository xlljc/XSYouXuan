package com.xsyx.dao;


import com.xsyx.vo.OrderDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderDetailsDao {

    /**
     * 商户端的条件查询
     * merId: 商户id
     * str: 客户手机号,客户名,客户真实姓名,商品名,订单编号
     * state: 状态0,配送中,1商户收货,2用户提货
     */
    List<OrderDetails> queryForMer(@Param("str") String str, @Param("merId") Integer merId, @Param("state") Integer state);


    int setState(@Param("ids") List<Integer> ids,@Param("state") Integer state);

    int setShouHuo(@Param("ids") List<Integer> ids);

    int setTiHuo(@Param("ids") List<Integer> ids);

    /**
     * 查询day天之内所有商品的销量
     * @param merId
     * @param day
     * @return
     */
    List<Map<String, Object>> queryIncomeByCom(@Param("merId") int merId,@Param("day") int day);

    List<Map<String, Object>> queryDateSum(@Param("merId") int merId,@Param("day") int day);

    List<Map<String, Object>> queryStateCount(@Param("merId") int merId);

    int queryYesterdayIncome(@Param("merId") int merId);
}
