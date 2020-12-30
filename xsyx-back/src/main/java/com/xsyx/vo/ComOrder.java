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
	/**删除状态, 0未删除, 1已删除*/
	private Integer isdelete;
	/**购物车id*/
	private Shopcar sid;
	private Integer totlemoney;
	private Integer merid;

	public ComOrder() {
		super();
	}
	public ComOrder(Integer id, Integer ordstate, String orderNumber, Integer isdelete, Shopcar sid,Integer totlemoney) {
		this.id = id;
		this.ordstate = ordstate;
		this.orderNumber = orderNumber;
		this.isdelete = isdelete;
		this.sid = sid;
		this.totlemoney = totlemoney;
		this.merid=merid;
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
	/**设置"删除状态, 0未删除, 1已删除"*/
	public void setIsdelete(Integer isdelete){
		this.isdelete = isdelete;
	}
	/**获取"删除状态, 0未删除, 1已删除"*/
	public Integer getIsdelete(){
		return isdelete;
	}
	public void setSid(Shopcar sid){
		this.sid = sid;
	}
	public Shopcar getSid(){
		return sid;
	}
	/**设置"总价"*/
	public void setTotlemoney(Integer totlemoney){
		this.totlemoney = totlemoney;
	}
	/**获取"总价"*/
	public Integer getTotlemoney(){
		return totlemoney;
	}

	/**设置"总价"*/
	public void setMerid(Integer merid){
		this.merid = merid;
	}
	/**获取"总价"*/
	public Integer getMerid(){
		return merid;
	}
	
	@Override
	public String toString() {
		return "com_order[" +
				"id = " + id +
				", ordstate = " + ordstate +
				", orderNumber = " + orderNumber +
				", isdelete = " + isdelete +
				", sid = " + sid +
				", totlemoney = " + totlemoney +
				", merid = " + merid +
				"]";
	}
}

