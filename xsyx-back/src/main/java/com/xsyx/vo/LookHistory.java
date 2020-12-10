package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  look_history<br/>
 * 表注释 : 用户浏览历史表
 */ 
@JsonIgnoreProperties(value = "handler")
public class LookHistory implements Serializable {

	/**id*/
	private Integer id;
	/**用户, 外键*/
	private User user;
	/**浏览商品, 外键*/
	private Commodity cid;
	/**浏览时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp time;

	public LookHistory() {
		super();
	}
	public LookHistory(Integer id,User user,Commodity cid,Timestamp time) {
		this.id = id;
		this.user = user;
		this.cid = cid;
		this.time = time;
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
	public void setCid(Commodity cid){
		this.cid = cid;
	}
	public Commodity getCid(){
		return cid;
	}
	/**设置"浏览时间"*/
	public void setTime(Timestamp time){
		this.time = time;
	}
	/**获取"浏览时间"*/
	public Timestamp getTime(){
		return time;
	}
	@Override
	public String toString() {
		return "look_history[" + 
			"id = " + id + 
			", user = " + user + 
			", cid = " + cid + 
			", time = " + time + 
			"]";
	}
}

