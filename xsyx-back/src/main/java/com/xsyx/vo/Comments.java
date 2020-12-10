package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  comments<br/>
 * 表注释 : 用户评价表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Comments implements Serializable {

	/**id*/
	private Integer id;
	/**评价内容*/
	private String content;
	/**评价时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp comtime;
	/**商品id*/
	private Commodity cid;
	/**用户id*/
	private User uid;
	/**评论删除状态, 0未删除, 1已删除*/
	private Integer isdelete;

	public Comments() {
		super();
	}
	public Comments(Integer id,String content,Timestamp comtime,Commodity cid,User uid,Integer isdelete) {
		this.id = id;
		this.content = content;
		this.comtime = comtime;
		this.cid = cid;
		this.uid = uid;
		this.isdelete = isdelete;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"评价内容"*/
	public void setContent(String content){
		this.content = content;
	}
	/**获取"评价内容"*/
	public String getContent(){
		return content;
	}
	/**设置"评价时间"*/
	public void setComtime(Timestamp comtime){
		this.comtime = comtime;
	}
	/**获取"评价时间"*/
	public Timestamp getComtime(){
		return comtime;
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
	/**设置"评论删除状态, 0未删除, 1已删除"*/
	public void setIsdelete(Integer isdelete){
		this.isdelete = isdelete;
	}
	/**获取"评论删除状态, 0未删除, 1已删除"*/
	public Integer getIsdelete(){
		return isdelete;
	}
	@Override
	public String toString() {
		return "comments[" + 
			"id = " + id + 
			", content = " + content + 
			", comtime = " + comtime + 
			", cid = " + cid + 
			", uid = " + uid + 
			", isdelete = " + isdelete + 
			"]";
	}
}

