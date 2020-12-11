package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 表名 :  information<br/>
 * 表注释 : 用户交流表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Information implements Serializable {

	/**id*/
	private Integer id;
	/**聊天信息*/
	private String content;
	/**发送时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp sendtime;
	/**发件人id*/
	private User uid;
	/**收件人id*/
	private Integer userid;
	/**消息接收状态*/
	private Integer infstate;
	/**是否已读, 1已读, 0未读*/
	private Integer isRead;

	public Information() {
		super();
	}
	public Information(Integer id, String content, Timestamp sendtime, User uid, Integer userid, Integer infstate, Integer isRead) {
		this.id = id;
		this.content = content;
		this.sendtime = sendtime;
		this.uid = uid;
		this.userid = userid;
		this.infstate = infstate;
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
	/**设置"聊天信息"*/
	public void setContent(String content){
		this.content = content;
	}
	/**获取"聊天信息"*/
	public String getContent(){
		return content;
	}
	/**设置"发送时间"*/
	public void setSendtime(Timestamp sendtime){
		this.sendtime = sendtime;
	}
	/**获取"发送时间"*/
	public Timestamp getSendtime(){
		return sendtime;
	}
	public void setUid(User uid){
		this.uid = uid;
	}
	public User getUid(){
		return uid;
	}
	/**设置"收件人id"*/
	public void setUserid(Integer userid){
		this.userid = userid;
	}
	/**获取"收件人id"*/
	public Integer getUserid(){
		return userid;
	}
	/**设置"消息接收状态"*/
	public void setInfstate(Integer infstate){
		this.infstate = infstate;
	}
	/**获取"消息接收状态"*/
	public Integer getInfstate(){
		return infstate;
	}
	/**设置"是否已读, 1已读, 0未读"*/
	public void setIsRead(Integer isRead){
		this.isRead = isRead;
	}
	/**获取"是否已读, 1已读, 0未读"*/
	public Integer getIsRead(){
		return isRead;
	}
	@Override
	public String toString() {
		return "information[" + 
			"id = " + id + 
			", content = " + content + 
			", sendtime = " + sendtime + 
			", uid = " + uid + 
			", userid = " + userid + 
			", infstate = " + infstate + 
			", isRead = " + isRead + 
			"]";
	}
}

