package com.xsyx.controller;

import com.xsyx.service.MerchantsService;
import com.xsyx.vo.Merchants;
import com.xsyx.vo.User;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchants")
public class MerchantsController {
    @Autowired
    MerchantsService merchantsService;

    @RequestMapping("/reg")
    public Message zcMerchants(Merchants merchants){
        
        return merchantsService.insert(merchants);
    }
}
