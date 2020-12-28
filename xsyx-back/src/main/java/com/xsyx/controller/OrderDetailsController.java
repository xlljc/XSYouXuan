package com.xsyx.controller;

import com.github.pagehelper.PageInfo;
import com.xsyx.dao.OrderDetailsDao;
import com.xsyx.service.OrderDetailsService;
import com.xsyx.vo.OrderDetails;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("/shouHuo")
    public Message shouHuo(@RequestParam("ids") List<Integer> ids,Integer merId) {
        return orderDetailsService.shouHuo(ids,merId);
    }

    @RequestMapping("/tiHuo")
    public Message tiHuo(@RequestParam("ids") List<Integer> ids,Integer merId) {
        return orderDetailsService.tiHuo(ids,merId);
    }


}
