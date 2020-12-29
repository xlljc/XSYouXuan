package com.xsyx.controller;

import com.github.pagehelper.PageInfo;
import com.xsyx.dao.CommodityDao;
import com.xsyx.service.CommodityService;
import com.xsyx.vo.ComLabel;
import com.xsyx.vo.ComType;
import com.xsyx.vo.Commodity;
import com.xsyx.vo.system.Message;
import com.xsyx.vo.system.PageVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public PageVo<Commodity> queryCommodityAll(String name,
                                               String state,
                                               @RequestParam(value = "page", defaultValue = "1") int page,
                                               @RequestParam(value = "rows", defaultValue = "5") int rows) {

        if (state.equals("全部")) {
            state = "";
        }
        if (state.equals("上架")) {
            state = "1";
        }
        if (state.equals("未上架")) {
            state = "0";
        }
        if (state.equals("下架")) {
            state = "2";
        }

        PageVo<Commodity> l = commodityService.querycountCommoditybyCond(name, state, page, rows);

        return l;
    }

    /**
     * 模糊查询所有商品
     *
     * @return 商品数据
     */
    @RequestMapping("/MoHuqueryAll")
    public List<Commodity> moHuqueryAll(String name, String state) {
        if (state.equals("全部")) {
            state = "";
        }
        if (state.equals("上架")) {
            state = "1";
        }
        if (state.equals("未上架")) {
            state = "0";
        }
        if (state.equals("下架")) {
            state = "2";
        }
        /*System.out.println(commodityService.MoHuquery(name,state));*/
        return commodityService.moHuquery(name, state);
    }

    /**
     * 添加商品
     *
     * @return 商品数据
     */
    @RequestMapping("/addCommodity")
    public Message addCommodity(String name,
                               String particulars,
                               String image,
                               String price,
                               String unit,
                               String specification,
                               String manufacturer,
                               String comtype) {

        Message message = new Message();
        int row = commodityService.addCommodity(name, particulars, image, price, unit, specification, manufacturer, comtype);
        if (row > 0) {
            message.flag = true;
            message.msg = "添加成功√";
            return message;
        }
        message.flag = false;
        message.msg = "添加失败×";
        return message;
    }

    /**
     * 修改商品
     */
    @RequestMapping("/updateCommodity")
    public Message updateCommodity(String name,
                                String particulars,
                                String image,
                                String price,
                                String unit,
                                String specification,
                                String manufacturer,
                                String comtype,
                                   String id) {

        Message message = new Message();
        int row = commodityService.updateCommodity(name, particulars, image, price, unit, specification, manufacturer, comtype, id);
        if (row > 0) {
            message.flag = true;
            message.msg = "修改成功√";
            return message;
        }
        message.flag = false;
        message.msg = "修改失败×";
        return message;
    }

    /**
     *根据id下架商品
     *
     */
    @RequestMapping("/delete")
    public Message deleteCommodity(String id) {
        Message message = new Message();

        int row = commodityService.deleteCommodity(id);
        if (row > 0) {
            message.flag = true;
            message.msg = "下架成功√";
            return message;
        }
        message.flag = false;
        message.msg = "下架失败×";
        return message;
    }
    /**
     * 上架商品
     */
    @RequestMapping("/up")
    public Message up(String id,
                      String putawayDate) {
        Message message = new Message();
        //如果上架时间不是null 上架修改最新和第一次上架时间
        int row = commodityService.up(id,putawayDate);
        if (row > 0) {
            message.flag = true;
            message.msg = "上架成功√";
            return message;
        }
        message.flag = false;
        message.msg = "上架失败×";
        return message;
    }
    /**
     * 查询所有商品类型
     */
    @RequestMapping("/queryAlltype")
    public List<ComType> queryAlltype() {

        /*System.out.println(commodityService.queryAlltype());*/
        return commodityService.queryAlltype();
    }

    /**
     * 添加商品类型
     * @return
     */
    @RequestMapping("/addCommodityType")
    public Message addCommodityType(String name) {
        Message message = new Message();
        int row = commodityService.addCommodityType(name);
        if (row > 0) {
            message.flag = true;
            message.msg = "添加成功√";
            return message;
        }
        message.flag = false;
        message.msg = "添加失败×";
        return message;
    }
    /**
     * 修改商品类型
     * @return
     */
    @RequestMapping("/updateCommodityType")
    public Message updateCommodityType(String id,String name) {
        Message message = new Message();
        int row = commodityService.updateCommodityType(id,name);
        if (row > 0) {
            message.flag = true;
            message.msg = "修改成功√";
            return message;
        }
        message.flag = false;
        message.msg = "修改失败×";
        return message;
    }
    /**
     * 删除商品类型
     * @return
     */
    @RequestMapping("/deleteType")
    public Message deleteType(String id) {
        Message message = new Message();
        int row = commodityService.deleteCommodityType(id);
        if (row > 0) {
            message.flag = true;
            message.msg = "删除成功√";
            return message;
        }
        message.flag = false;
        message.msg = "删除失败×";
        return message;
    }

    /**
     * 查询所有商品标签
     */
    @RequestMapping("/queryAlllabel")
    public List<ComLabel> queryAlllabel() {

        /*System.out.println(commodityService.queryAlltype());*/
        return commodityService.queryAllLabel();
    }

    //根据id查询
    @RequestMapping("/queryComShpId")
    public Commodity queryBySpid(int id){
        return commodityService.querySpByid(id);
    }
    /**
     * 查询首页的商品
     * @return
     */
    @RequestMapping("/queryHome")
    public Map<String,Object> queryHome() {
        return commodityService.queryHome();
    }

    /**
     * 搜索商品提示
     * @param str
     * @return
     */
    @RequestMapping("/searchTips")
    public List<Commodity> searchTips(String str) {
        return commodityService.searchTips(str);
    }

    /**
     * 搜索商品
     * @param str
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageInfo<Commodity> search(String str,
                                      @RequestParam(value = "page", defaultValue = "1") int page,
                                      @RequestParam(value = "rows", defaultValue = "10") int rows) {
        return commodityService.search(str,page,rows);
    }

}
