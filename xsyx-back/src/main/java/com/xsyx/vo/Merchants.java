package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 表名 :  merchants<br/>
 * 表注释 : 商户表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Merchants implements Serializable {

	/**id*/
	private Integer id;
	/**商户名称*/
	private String name;
	/**商户地址*/
	private String address;
	/**商户电话*/
	private String phone;
	/**经度*/
	private Float longitude;
	/**纬度*/
	private Float latitude;
	/**营业起始时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date openTimeFrom;
	/**营业结束时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date openTimeTo;
	/**商户备注*/
	private String remark;
	/**商户状态, 0 被冻结, 1正常 , -1删除*/
	private Integer state;
	private List<PickupMerchants> pickupMerchantss;
	private List<User> users;

	public Merchants() {
		super();
	}
	public Merchants(Integer id,String name,String address,String phone,Float longitude,Float latitude,Date openTimeFrom,Date openTimeTo,String remark,Integer state) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.longitude = longitude;
		this.latitude = latitude;
		this.openTimeFrom = openTimeFrom;
		this.openTimeTo = openTimeTo;
		this.remark = remark;
		this.state = state;
	}
	public Merchants(Integer id, String name, String address, String phone, Float longitude, Float latitude, Date openTimeFrom, Date openTimeTo, String remark, Integer state, List<PickupMerchants> pickupMerchantss, List<User> users) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.longitude = longitude;
		this.latitude = latitude;
		this.openTimeFrom = openTimeFrom;
		this.openTimeTo = openTimeTo;
		this.remark = remark;
		this.state = state;
		this.pickupMerchantss = pickupMerchantss;
		this.users = users;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"商户名称"*/
	public void setName(String name){
		this.name = name;
	}
	/**获取"商户名称"*/
	public String getName(){
		return name;
	}
	/**设置"商户地址"*/
	public void setAddress(String address){
		this.address = address;
	}
	/**获取"商户地址"*/
	public String getAddress(){
		return address;
	}
	/**设置"商户电话"*/
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**获取"商户电话"*/
	public String getPhone(){
		return phone;
	}
	/**设置"经度"*/
	public void setLongitude(Float longitude){
		this.longitude = longitude;
	}
	/**获取"经度"*/
	public Float getLongitude(){
		return longitude;
	}
	/**设置"纬度"*/
	public void setLatitude(Float latitude){
		this.latitude = latitude;
	}
	/**获取"纬度"*/
	public Float getLatitude(){
		return latitude;
	}
	/**设置"营业起始时间"*/
	public void setOpenTimeFrom(Date openTimeFrom){
		this.openTimeFrom = openTimeFrom;
	}
	/**获取"营业起始时间"*/
	public Date getOpenTimeFrom(){
		return openTimeFrom;
	}
	/**设置"营业结束时间"*/
	public void setOpenTimeTo(Date openTimeTo){
		this.openTimeTo = openTimeTo;
	}
	/**获取"营业结束时间"*/
	public Date getOpenTimeTo(){
		return openTimeTo;
	}
	/**设置"商户备注"*/
	public void setRemark(String remark){
		this.remark = remark;
	}
	/**获取"商户备注"*/
	public String getRemark(){
		return remark;
	}
	/**设置"商户状态, 0 被冻结, 1正常 , -1删除"*/
	public void setState(Integer state){
		this.state = state;
	}
	/**获取"商户状态, 0 被冻结, 1正常 , -1删除"*/
	public Integer getState(){
		return state;
	}
	public void setPickupMerchantss(List<PickupMerchants> pickupMerchantss){
		this.pickupMerchantss = pickupMerchantss;
	}
	public List<PickupMerchants> getPickupMerchantss(){
		return pickupMerchantss;
	}
	public void setUsers(List<User> users){
		this.users = users;
	}
	public List<User> getUsers(){
		return users;
	}
	@Override
	public String toString() {
		return "merchants[" + 
			"id = " + id + 
			", name = " + name + 
			", address = " + address + 
			", phone = " + phone + 
			", longitude = " + longitude + 
			", latitude = " + latitude + 
			", openTimeFrom = " + openTimeFrom + 
			", openTimeTo = " + openTimeTo + 
			", remark = " + remark + 
			", state = " + state + 
			", pickupMerchantss = " + pickupMerchantss + 
			", users = " + users + 
			"]";
	}
}

