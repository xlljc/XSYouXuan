package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  purchase<br/>
 * 表注释 : 采购表（采购申请记录）
 */ 
@JsonIgnoreProperties(value = "handler")
public class Purchase implements Serializable {

	/**记录编号*/
	private Integer id;
	/**订单id*/
	private Purchaseorder orderid;
	/**商品id*/
	private Commodity commodityid;
	/**商品名*/
	private String commodityname;
	/**商品价格*/
	private Float price;
	/**商品数量*/
	private Integer commoditysum;

	public Purchase() {
		super();
	}
	public Purchase(Integer id,Purchaseorder orderid,Commodity commodityid,String commodityname,Float price,Integer commoditysum) {
		this.id = id;
		this.orderid = orderid;
		this.commodityid = commodityid;
		this.commodityname = commodityname;
		this.price = price;
		this.commoditysum = commoditysum;
	}
	/**设置"记录编号"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"记录编号"*/
	public Integer getId(){
		return id;
	}
	public void setOrderid(Purchaseorder orderid){
		this.orderid = orderid;
	}
	public Purchaseorder getOrderid(){
		return orderid;
	}
	public void setCommodityid(Commodity commodityid){
		this.commodityid = commodityid;
	}
	public Commodity getCommodityid(){
		return commodityid;
	}
	/**设置"商品名"*/
	public void setCommodityname(String commodityname){
		this.commodityname = commodityname;
	}
	/**获取"商品名"*/
	public String getCommodityname(){
		return commodityname;
	}
	/**设置"商品价格"*/
	public void setPrice(Float price){
		this.price = price;
	}
	/**获取"商品价格"*/
	public Float getPrice(){
		return price;
	}
	/**设置"商品数量"*/
	public void setCommoditysum(Integer commoditysum){
		this.commoditysum = commoditysum;
	}
	/**获取"商品数量"*/
	public Integer getCommoditysum(){
		return commoditysum;
	}
	@Override
	public String toString() {
		return "purchase[" + 
			"id = " + id + 
			", orderid = " + orderid + 
			", commodityid = " + commodityid + 
			", commodityname = " + commodityname + 
			", price = " + price + 
			", commoditysum = " + commoditysum + 
			"]";
	}
}

