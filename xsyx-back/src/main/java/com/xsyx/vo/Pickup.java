package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 表名 :  pickup<br/>
 * 表注释 : 收货表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Pickup implements Serializable {

	/**id*/
	private Integer id;
	/**收货地址*/
	private String address;
	/**收货电话*/
	private String phone;
	/**收货时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp ptime;
	/**收货状态, 0未收货, 1收货*/
	private String pstate;
	/**用户id*/
	private Integer uid;

	public Pickup() {
		super();
	}
	public Pickup(Integer id, String address, String phone, Timestamp ptime, String pstate, Integer uid) {
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.ptime = ptime;
		this.pstate = pstate;
		this.uid = uid;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"收货地址"*/
	public void setAddress(String address){
		this.address = address;
	}
	/**获取"收货地址"*/
	public String getAddress(){
		return address;
	}
	/**设置"收货电话"*/
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**获取"收货电话"*/
	public String getPhone(){
		return phone;
	}
	/**设置"收货时间"*/
	public void setPtime(Timestamp ptime){
		this.ptime = ptime;
	}
	/**获取"收货时间"*/
	public Timestamp getPtime(){
		return ptime;
	}
	/**设置"收货状态, 0未收货, 1收货"*/
	public void setPstate(String pstate){
		this.pstate = pstate;
	}
	/**获取"收货状态, 0未收货, 1收货"*/
	public String getPstate(){
		return pstate;
	}
	/**设置"用户id"*/
	public void setUid(Integer uid){
		this.uid = uid;
	}
	/**获取"用户id"*/
	public Integer getUid(){
		return uid;
	}
	@Override
	public String toString() {
		return "pickup[" + 
			"id = " + id + 
			", address = " + address + 
			", phone = " + phone + 
			", ptime = " + ptime + 
			", pstate = " + pstate + 
			", uid = " + uid + 
			"]";
	}
}

