package com.xsyx.vo;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  com_discount<br/>
 * 表注释 : 商品折扣表
 */ 
@JsonIgnoreProperties(value = "handler")
public class ComDiscount implements Serializable {

	/**id*/
	private Integer id;
	/**商品id , 外键*/
	private Integer commodity;
	/**起始时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date startTime;
	/**结束时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;
	/**折率 , 0 - 10之间*/
	private Float discount;
	/**备注*/
	private String remark;

	public ComDiscount() {
		super();
	}
	public ComDiscount(Integer id,Integer commodity,Date startTime,Date endTime,Float discount,String remark) {
		this.id = id;
		this.commodity = commodity;
		this.startTime = startTime;
		this.endTime = endTime;
		this.discount = discount;
		this.remark = remark;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"商品id , 外键"*/
	public void setCommodity(Integer commodity){
		this.commodity = commodity;
	}
	/**获取"商品id , 外键"*/
	public Integer getCommodity(){
		return commodity;
	}
	/**设置"起始时间"*/
	public void setStartTime(Date startTime){
		this.startTime = startTime;
	}
	/**获取"起始时间"*/
	public Date getStartTime(){
		return startTime;
	}
	/**设置"结束时间"*/
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
	/**获取"结束时间"*/
	public Date getEndTime(){
		return endTime;
	}
	/**设置"折率 , 0 - 10之间"*/
	public void setDiscount(Float discount){
		this.discount = discount;
	}
	/**获取"折率 , 0 - 10之间"*/
	public Float getDiscount(){
		return discount;
	}
	/**设置"备注"*/
	public void setRemark(String remark){
		this.remark = remark;
	}
	/**获取"备注"*/
	public String getRemark(){
		return remark;
	}
	@Override
	public String toString() {
		return "com_discount[" + 
			"id = " + id + 
			", commodity = " + commodity + 
			", startTime = " + startTime + 
			", endTime = " + endTime + 
			", discount = " + discount + 
			", remark = " + remark + 
			"]";
	}
}

