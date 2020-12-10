package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  search_record<br/>
 * 表注释 : 用户搜索记录表
 */ 
@JsonIgnoreProperties(value = "handler")
public class SearchRecord implements Serializable {

	/**id*/
	private Integer id;
	/**用户,外键*/
	private User user;
	/**搜索内容*/
	private String content;
	/**搜索时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp time;

	public SearchRecord() {
		super();
	}
	public SearchRecord(Integer id,User user,String content,Timestamp time) {
		this.id = id;
		this.user = user;
		this.content = content;
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
	/**设置"搜索内容"*/
	public void setContent(String content){
		this.content = content;
	}
	/**获取"搜索内容"*/
	public String getContent(){
		return content;
	}
	/**设置"搜索时间"*/
	public void setTime(Timestamp time){
		this.time = time;
	}
	/**获取"搜索时间"*/
	public Timestamp getTime(){
		return time;
	}
	@Override
	public String toString() {
		return "search_record[" + 
			"id = " + id + 
			", user = " + user + 
			", content = " + content + 
			", time = " + time + 
			"]";
	}
}

