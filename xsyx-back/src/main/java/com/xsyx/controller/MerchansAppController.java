package com.xsyx.controller;

import com.xsyx.service.MerchantsAppService;
import com.xsyx.service.MerchantsService;
import com.xsyx.vo.Merchants;
import com.xsyx.vo.MerchantsApply;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchantsApp")
public class MerchansAppController {
    @Autowired
    MerchantsAppService merchantsAppService;

    @RequestMapping("/reg")
    public Message zcMerchants(MerchantsApply merchantsApply){

        return merchantsAppService.insert(merchantsApply);
    }
}
