package com.xsyx.controller;

import com.github.pagehelper.PageInfo;
import com.xsyx.dao.CommodityDao;
import com.xsyx.service.CommodityService;
import com.xsyx.vo.ComType;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.system.Message;
import com.xsyx.vo.system.PageVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品控制层
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    //分页模糊查询所有
    @RequestMapping("/queryCommodityAll")
    public PageVo<Commodity> queryCommodityAll (String name,
                                                String state,
                                               @RequestParam(value = "page", defaultValue = "1") int page,
                                               @RequestParam(value = "rows",defaultValue = "5") int rows){

        if (state.equals("全部")){
            state="";
        }
        if (state.equals("上架")){
            state="1";
        }
        if (state.equals("下架")){
            state="0";
        }


        PageVo<Commodity> l=commodityService.querycountCommoditybyCond(name,state,page,rows);
       /* System.out.println(name);
        System.out.println(state);
        System.out.println(page);
        System.out.println(rows);
        System.out.println(l.getRows());
        System.out.println(l.getTotal());*/
        return l;
    }

    /**
     * 模糊查询所有商品
     *
     * @return 商品数据
     */
    @RequestMapping("/MoHuqueryAll")
    public List<Commodity> moHuqueryAll(String name,String state) {
        if (state.equals("全部")){
            state="";
        }
        if (state.equals("上架")){
            state="1";
        }
        if (state.equals("下架")){
            state="0";
        }
        /*System.out.println(commodityService.MoHuquery(name,state));*/
        return commodityService.moHuquery(name,state);
    }



    /**
     * 添加商品
     *
     * @return 商品数据
     */
    @RequestMapping("/addCommodity")
    public String addCommodity(String name,
                               String particulars,
                               String image,
                               String price,
                               String unit,
                               String specification,
                               String manufacturer,
                               String comtype) {

 /*       System.out.println("1:"+name);
        System.out.println("2:"+particulars);
        System.out.println("3:"+image);
        System.out.println("4:"+price);
        System.out.println("5:"+unit);
        System.out.println("6:"+specification);
        System.out.println("7:"+manufacturer);
        System.out.println("8:"+comtype);*/
        Message message= new Message();
        int row=commodityService.addCommodity(name,particulars,image,price,unit,specification,manufacturer,comtype);
        if (row>0){
           message.flag=true;
           message.msg="添加成功";
            return "添加成功";
        }
        message.flag=false;
        message.msg="添加失败";
        return "添加失败";
    }

    /**
     *根据id下架商品
     *
     */
    /*@RequestMapping("/delete")
    public Message delete(Integer id, HttpSession session) {

        return employeeService.delete(id, session);
    }*/

}
