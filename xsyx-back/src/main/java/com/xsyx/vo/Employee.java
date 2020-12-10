package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

import java.sql.Timestamp;
import java.util.List;

/**
 * 表名 :  employee<br/>
 * 表注释 : 员工表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Employee implements Serializable {

	/**id*/
	private Integer id;
	/**员工姓名*/
	private String name;
	/**登录密码*/
	private String password;
	/**头像*/
	private String image;
	/**性别*/
	private String sex;
	/**手机号*/
	private String phone;
	/**身份证号码*/
	private String icCard;
	/**员工住址*/
	private String address;
	/**邮箱*/
	private String email;
	/**备注*/
	private String remark;
	/**最后一次登录日期*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp lastLoginTime;
	/**员工状态*/
	private Integer state;
	private List<Purchaseorder> purchaseorders;

	public Employee() {
		super();
	}
	public Employee(Integer id,String name,String password,String image,String sex,String phone,String icCard,String address,String email,String remark,Timestamp lastLoginTime,Integer state) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.image = image;
		this.sex = sex;
		this.phone = phone;
		this.icCard = icCard;
		this.address = address;
		this.email = email;
		this.remark = remark;
		this.lastLoginTime = lastLoginTime;
		this.state = state;
	}
	public Employee(Integer id,String name,String password,String image,String sex,String phone,String icCard,String address,String email,String remark,Timestamp lastLoginTime,Integer state,List<Purchaseorder> purchaseorders) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.image = image;
		this.sex = sex;
		this.phone = phone;
		this.icCard = icCard;
		this.address = address;
		this.email = email;
		this.remark = remark;
		this.lastLoginTime = lastLoginTime;
		this.state = state;
		this.purchaseorders = purchaseorders;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"员工姓名"*/
	public void setName(String name){
		this.name = name;
	}
	/**获取"员工姓名"*/
	public String getName(){
		return name;
	}
	/**设置"登录密码"*/
	public void setPassword(String password){
		this.password = password;
	}
	/**获取"登录密码"*/
	public String getPassword(){
		return password;
	}
	/**设置"头像"*/
	public void setImage(String image){
		this.image = image;
	}
	/**获取"头像"*/
	public String getImage(){
		return image;
	}
	/**设置"性别"*/
	public void setSex(String sex){
		this.sex = sex;
	}
	/**获取"性别"*/
	public String getSex(){
		return sex;
	}
	/**设置"手机号"*/
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**获取"手机号"*/
	public String getPhone(){
		return phone;
	}
	/**设置"身份证号码"*/
	public void setIcCard(String icCard){
		this.icCard = icCard;
	}
	/**获取"身份证号码"*/
	public String getIcCard(){
		return icCard;
	}
	/**设置"员工住址"*/
	public void setAddress(String address){
		this.address = address;
	}
	/**获取"员工住址"*/
	public String getAddress(){
		return address;
	}
	/**设置"邮箱"*/
	public void setEmail(String email){
		this.email = email;
	}
	/**获取"邮箱"*/
	public String getEmail(){
		return email;
	}
	/**设置"备注"*/
	public void setRemark(String remark){
		this.remark = remark;
	}
	/**获取"备注"*/
	public String getRemark(){
		return remark;
	}
	/**获取"最后一次登录日期"*/
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	/**获取"最后一次登录日期"*/
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	/**设置"员工状态"*/
	public void setState(Integer state){
		this.state = state;
	}
	/**获取"员工状态"*/
	public Integer getState(){
		return state;
	}
	public void setPurchaseorders(List<Purchaseorder> purchaseorders){
		this.purchaseorders = purchaseorders;
	}
	public List<Purchaseorder> getPurchaseorders(){
		return purchaseorders;
	}
	@Override
	public String toString() {
		return "employee[" + 
			"id = " + id + 
			", name = " + name + 
			", password = " + password + 
			", image = " + image + 
			", sex = " + sex + 
			", phone = " + phone + 
			", icCard = " + icCard + 
			", address = " + address + 
			", email = " + email + 
			", remark = " + remark + 
			", lastLoginTime = " + lastLoginTime +
			", state = " + state +
			", purchaseorders = " + purchaseorders + 
			"]";
	}
}

