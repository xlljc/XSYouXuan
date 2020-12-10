package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  star<br/>
 * 表注释 : 评星表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Star implements Serializable {

	/**id*/
	private Integer id;
	/**用户id*/
	private User uid;
	/**商品id*/
	private Commodity cid;
	/**星星数量*/
	private Float count;

	public Star() {
		super();
	}
	public Star(Integer id,User uid,Commodity cid,Float count) {
		this.id = id;
		this.uid = uid;
		this.cid = cid;
		this.count = count;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	public void setUid(User uid){
		this.uid = uid;
	}
	public User getUid(){
		return uid;
	}
	public void setCid(Commodity cid){
		this.cid = cid;
	}
	public Commodity getCid(){
		return cid;
	}
	/**设置"星星数量"*/
	public void setCount(Float count){
		this.count = count;
	}
	/**获取"星星数量"*/
	public Float getCount(){
		return count;
	}
	@Override
	public String toString() {
		return "star[" + 
			"id = " + id + 
			", uid = " + uid + 
			", cid = " + cid + 
			", count = " + count + 
			"]";
	}
}

