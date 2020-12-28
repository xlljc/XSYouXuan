package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 表名 :  shopcar<br/>
 * 表注释 : 购物车表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Shopcar implements Serializable {

	/**id*/
	private Integer id;
	/**数量*/
	private Integer number;
	/**加入购物车时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp jointime;
	/**总价*/
	private Float totalprice;
	/**商品id*/
	private Commodity cid;
	/**用户id*/
	private User uid;
	private List<ComOrder> comOrders;

	public Shopcar() {
		super();
	}
	public Shopcar(Integer id, Integer number, Timestamp jointime, Float totalprice, Commodity cid, User uid) {
		this.id = id;
		this.number = number;
		this.jointime = jointime;
		this.totalprice = totalprice;
		this.cid = cid;
		this.uid = uid;
	}
	public Shopcar(Integer id, Integer number, Timestamp jointime, Float totalprice, Commodity cid, User uid, List<ComOrder> comOrders) {
		this.id = id;
		this.number = number;
		this.jointime = jointime;
		this.totalprice = totalprice;
		this.cid = cid;
		this.uid = uid;
		this.comOrders = comOrders;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"数量"*/
	public void setNumber(Integer number){
		this.number = number;
	}
	/**获取"数量"*/
	public Integer getNumber(){
		return number;
	}
	/**设置"加入购物车时间"*/
	public void setJointime(Timestamp jointime){
		this.jointime = jointime;
	}
	/**获取"加入购物车时间"*/
	public Timestamp getJointime(){
		return jointime;
	}
	/**设置"总价"*/
	public void setTotalprice(Float totalprice){
		this.totalprice = totalprice;
	}
	/**获取"总价"*/
	public Float getTotalprice(){
		return totalprice;
	}
	public void setCid(Commodity cid){
		this.cid = cid;
	}
	public Commodity getCid(){
		return cid;
	}
	public void setUid(User uid){
		this.uid = uid;
	}
	public User getUid(){
		return uid;
	}
	public void setComOrders(List<ComOrder> comOrders){
		this.comOrders = comOrders;
	}
	public List<ComOrder> getComOrders(){
		return comOrders;
	}
	@Override
	public String toString() {
		return "shopcar[" + 
			"id = " + id + 
			", number = " + number + 
			", jointime = " + jointime + 
			", totalprice = " + totalprice + 
			", cid = " + cid + 
			", uid = " + uid + 
			", comOrders = " + comOrders + 
			"]";
	}
}

