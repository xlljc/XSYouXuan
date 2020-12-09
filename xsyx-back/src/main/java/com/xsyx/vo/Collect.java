package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  collect<br/>
 * 表注释 : 收藏表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Collect implements Serializable {

	/**id*/
	private Integer id;
	/**收藏时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp coltime;
	/**商品id*/
	private Commodity cid;

	public Collect() {
		super();
	}
	public Collect(Integer id,Timestamp coltime,Commodity cid) {
		this.id = id;
		this.coltime = coltime;
		this.cid = cid;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"收藏时间"*/
	public void setColtime(Timestamp coltime){
		this.coltime = coltime;
	}
	/**获取"收藏时间"*/
	public Timestamp getColtime(){
		return coltime;
	}
	public void setCid(Commodity cid){
		this.cid = cid;
	}
	public Commodity getCid(){
		return cid;
	}
	@Override
	public String toString() {
		return "collect[" + 
			"id = " + id + 
			", coltime = " + coltime + 
			", cid = " + cid + 
			"]";
	}
}

