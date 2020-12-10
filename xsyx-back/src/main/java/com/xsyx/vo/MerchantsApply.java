package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 表名 :  merchants_apply<br/>
 * 表注释 : 商户申请表
 */ 
@JsonIgnoreProperties(value = "handler")
public class MerchantsApply implements Serializable {

	/**id*/
	private Integer id;
	/**用户id外键*/
	private User userId;
	/**商户名称*/
	private String name;
	/**商户地址*/
	private String address;
	/**申请时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp applyTime;
	/**用户消息*/
	private String userMessage;
	/**审核状态 , 0未审核*/
	private Integer state;
	/**系统消息*/
	private String systemMessage;
	/**是否已读*/
	private Integer isRead;

	public MerchantsApply() {
		super();
	}
	public MerchantsApply(Integer id, User userId, String name, String address, Timestamp applyTime, String userMessage, Integer state, String systemMessage, Integer isRead) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.applyTime = applyTime;
		this.userMessage = userMessage;
		this.state = state;
		this.systemMessage = systemMessage;
		this.isRead = isRead;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	public void setUserId(User userId){
		this.userId = userId;
	}
	public User getUserId(){
		return userId;
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
	/**设置"申请时间"*/
	public void setApplyTime(Timestamp applyTime){
		this.applyTime = applyTime;
	}
	/**获取"申请时间"*/
	public Timestamp getApplyTime(){
		return applyTime;
	}
	/**设置"用户消息"*/
	public void setUserMessage(String userMessage){
		this.userMessage = userMessage;
	}
	/**获取"用户消息"*/
	public String getUserMessage(){
		return userMessage;
	}
	/**设置"审核状态 , 0未审核"*/
	public void setState(Integer state){
		this.state = state;
	}
	/**获取"审核状态 , 0未审核"*/
	public Integer getState(){
		return state;
	}
	/**设置"系统消息"*/
	public void setSystemMessage(String systemMessage){
		this.systemMessage = systemMessage;
	}
	/**获取"系统消息"*/
	public String getSystemMessage(){
		return systemMessage;
	}
	/**设置"是否已读"*/
	public void setIsRead(Integer isRead){
		this.isRead = isRead;
	}
	/**获取"是否已读"*/
	public Integer getIsRead(){
		return isRead;
	}
	@Override
	public String toString() {
		return "merchants_apply[" + 
			"id = " + id + 
			", userId = " + userId + 
			", name = " + name + 
			", address = " + address + 
			", applyTime = " + applyTime + 
			", userMessage = " + userMessage + 
			", state = " + state + 
			", systemMessage = " + systemMessage + 
			", isRead = " + isRead + 
			"]";
	}
}

