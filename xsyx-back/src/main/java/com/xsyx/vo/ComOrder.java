package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  com_order<br/>
 * 表注释 : 订单表
 */ 
@JsonIgnoreProperties(value = "handler")
public class ComOrder implements Serializable {

	/**id*/
	private Integer id;
	/**订单状态*/
	private Integer ordstate;
	/**订单编号*/
	private String orderNumber;
	/**删除状态*/
	private Integer isdelete;
	/**购物车id*/
	private Shopcar sid;

	public ComOrder() {
		super();
	}
	public ComOrder(Integer id,Integer ordstate,String orderNumber,Integer isdelete,Shopcar sid) {
		this.id = id;
		this.ordstate = ordstate;
		this.orderNumber = orderNumber;
		this.isdelete = isdelete;
		this.sid = sid;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"订单状态"*/
	public void setOrdstate(Integer ordstate){
		this.ordstate = ordstate;
	}
	/**获取"订单状态"*/
	public Integer getOrdstate(){
		return ordstate;
	}
	/**设置"订单编号"*/
	public void setOrderNumber(String orderNumber){
		this.orderNumber = orderNumber;
	}
	/**获取"订单编号"*/
	public String getOrderNumber(){
		return orderNumber;
	}
	/**设置"删除状态"*/
	public void setIsdelete(Integer isdelete){
		this.isdelete = isdelete;
	}
	/**获取"删除状态"*/
	public Integer getIsdelete(){
		return isdelete;
	}
	public void setSid(Shopcar sid){
		this.sid = sid;
	}
	public Shopcar getSid(){
		return sid;
	}
	@Override
	public String toString() {
		return "com_order[" + 
			"id = " + id + 
			", ordstate = " + ordstate + 
			", orderNumber = " + orderNumber + 
			", isdelete = " + isdelete + 
			", sid = " + sid + 
			"]";
	}
}

