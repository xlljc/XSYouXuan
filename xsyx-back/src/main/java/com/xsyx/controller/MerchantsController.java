package com.xsyx.controller;
import com.xsyx.service.MerchantsService;
import com.xsyx.vo.Merchants;
import com.xsyx.vo.MerchantsApply;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchants")
public class MerchantsController {
    @Autowired
    private MerchantsService merchantsService;

//    @RequestMapping("/reg")
//    public Message zcMerchants(Merchants merchants){
//
//        return merchantsService.insert(merchants);
//    }
    //查询商户
    @RequestMapping("/query")
    public PageInfo<Merchants> query(String str,
                                     @RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "10") Integer row) {
        return merchantsService.query(str,page,row);
    }

    //删除商户
    @RequestMapping("/delete")
    public Message delete(Integer merId,Integer empId) {
        return merchantsService.delete(merId,empId);
    }

    //修改商户
    @RequestMapping("/update")
    public Message update(Merchants merchants,Integer empId) {
        return merchantsService.update(merchants,empId);
    }

    //商户申请查询
    @RequestMapping("/queryApply")
    public PageInfo<MerchantsApply> queryApply(String str,
                                          @RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer row) {
        return merchantsService.queryApply(str,page,row);
    }

    //商户申请审批
    @RequestMapping("/approval")
    public Message approval(Integer id,Boolean flag,String message,Integer empId) {
        return merchantsService.approval(id,flag,message,empId);
    }

}
