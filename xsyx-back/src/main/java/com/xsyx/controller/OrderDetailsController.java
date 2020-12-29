package com.xsyx.controller;

import com.github.pagehelper.PageInfo;
import com.xsyx.service.OrderDetailsService;
import com.xsyx.vo.OrderDetails;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @RequestMapping("/queryForMer")
    public PageInfo<OrderDetails> queryForMer(@RequestParam(defaultValue = "") String str, Integer merId, Integer state,
                                              @RequestParam(defaultValue = "1") Integer page,
                                              @RequestParam(defaultValue = "10") Integer row) {
        return orderDetailsService.queryForMer(str,merId,state,page,row);
    }

    /**
     * 查询营收情况
     * @param merId 商户id
     * @param day 日期范围
     * @return
     */
    @RequestMapping("/statistical")
    public Map<String,Object> statistical(Integer merId,@RequestParam(defaultValue = "0") Integer day) {
        return orderDetailsService.statistical(merId,day);
    }

    @RequestMapping("/shouHuo")
    public Message shouHuo(@RequestParam("ids") List<Integer> ids,Integer merId) {
        return orderDetailsService.shouHuo(ids,merId);
    }

    @RequestMapping("/tiHuo")
    public Message tiHuo(@RequestParam("ids") List<Integer> ids,Integer merId) {
        return orderDetailsService.tiHuo(ids,merId);
    }


}
