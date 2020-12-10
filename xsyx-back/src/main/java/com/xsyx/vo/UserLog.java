package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  user_log<br/>
 * 表注释 : 用户日志表
 */ 
@JsonIgnoreProperties(value = "handler")
public class UserLog implements Serializable {

	/**id*/
	private Integer id;
	/**用户,外键*/
	private User user;
	/**日志内容, 链接占位符请使用 ${name}*/
	private String content;
	/**链接地址*/
	private String link;
	/**时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp time;

	public UserLog() {
		super();
	}
	public UserLog(Integer id,User user,String content,String link,Timestamp time) {
		this.id = id;
		this.user = user;
		this.content = content;
		this.link = link;
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
	/**设置"日志内容, 链接占位符请使用 ${name}"*/
	public void setContent(String content){
		this.content = content;
	}
	/**获取"日志内容, 链接占位符请使用 ${name}"*/
	public String getContent(){
		return content;
	}
	/**设置"链接地址"*/
	public void setLink(String link){
		this.link = link;
	}
	/**获取"链接地址"*/
	public String getLink(){
		return link;
	}
	/**设置"时间"*/
	public void setTime(Timestamp time){
		this.time = time;
	}
	/**获取"时间"*/
	public Timestamp getTime(){
		return time;
	}
	@Override
	public String toString() {
		return "user_log[" + 
			"id = " + id + 
			", user = " + user + 
			", content = " + content + 
			", link = " + link + 
			", time = " + time + 
			"]";
	}
}

