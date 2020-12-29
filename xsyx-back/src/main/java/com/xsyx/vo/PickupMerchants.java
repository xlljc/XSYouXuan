package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 表名 :  pickup_merchants<br/>
 * 表注释 : 收货门店表(收货地址)
 */ 
@JsonIgnoreProperties(value = "handler")
public class PickupMerchants implements Serializable {

	/**id*/
	private Integer id;
	/**用户,外键*/
	private User user;
	/**收货商户*/
	private Merchants merchant;
	/**备注*/
	private String remark;
	/**创建时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp createTime;

	public PickupMerchants() {
		super();
	}
	public PickupMerchants(Integer id, User user, Merchants merchant, String remark, Timestamp createTime) {
		this.id = id;
		this.user = user;
		this.merchant = merchant;
		this.remark = remark;
		this.createTime = createTime;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}
	public void setMerchant(Merchants merchant){
		this.merchant = merchant;
	}
	public Merchants getMerchant(){
		return merchant;
	}
	/**设置"备注"*/
	public void setRemark(String remark){
		this.remark = remark;
	}
	/**获取"备注"*/
	public String getRemark(){
		return remark;
	}
	/**设置"创建时间"*/
	public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	}
	/**获取"创建时间"*/
	public Timestamp getCreateTime(){
		return createTime;
	}
	@Override
	public String toString() {
		return "pickup_merchants[" + 
			"id = " + id + 
			", user = " + user + 
			", merchant = " + merchant + 
			", remark = " + remark + 
			", createTime = " + createTime + 
			"]";
	}
}

