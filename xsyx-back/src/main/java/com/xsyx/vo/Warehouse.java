package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  warehouse<br/>
 * 表注释 : 仓库表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Warehouse implements Serializable {

	/**仓库编号*/
	private Integer warid;
	/**仓库名*/
	private String warname;
	/**仓库类型*/
	private String wartype;
	/**仓库容量*/
	private Integer warcapacity;
	/**仓库地址*/
	private String waraddress;
	/**经度*/
	private Float longitude;
	/**纬度*/
	private Float latitude;
	/**仓库状态*/
	private String warstate;

	public Warehouse() {
		super();
	}
	public Warehouse(Integer warid,String warname,String wartype,Integer warcapacity,String waraddress,Float longitude,Float latitude,String warstate) {
		this.warid = warid;
		this.warname = warname;
		this.wartype = wartype;
		this.warcapacity = warcapacity;
		this.waraddress = waraddress;
		this.longitude = longitude;
		this.latitude = latitude;
		this.warstate = warstate;
	}
	/**设置"仓库编号"*/
	public void setWarid(Integer warid){
		this.warid = warid;
	}
	/**获取"仓库编号"*/
	public Integer getWarid(){
		return warid;
	}
	/**设置"仓库名"*/
	public void setWarname(String warname){
		this.warname = warname;
	}
	/**获取"仓库名"*/
	public String getWarname(){
		return warname;
	}
	/**设置"仓库类型"*/
	public void setWartype(String wartype){
		this.wartype = wartype;
	}
	/**获取"仓库类型"*/
	public String getWartype(){
		return wartype;
	}
	/**设置"仓库容量"*/
	public void setWarcapacity(Integer warcapacity){
		this.warcapacity = warcapacity;
	}
	/**获取"仓库容量"*/
	public Integer getWarcapacity(){
		return warcapacity;
	}
	/**设置"仓库地址"*/
	public void setWaraddress(String waraddress){
		this.waraddress = waraddress;
	}
	/**获取"仓库地址"*/
	public String getWaraddress(){
		return waraddress;
	}
	/**设置"经度"*/
	public void setLongitude(Float longitude){
		this.longitude = longitude;
	}
	/**获取"经度"*/
	public Float getLongitude(){
		return longitude;
	}
	/**设置"纬度"*/
	public void setLatitude(Float latitude){
		this.latitude = latitude;
	}
	/**获取"纬度"*/
	public Float getLatitude(){
		return latitude;
	}
	/**设置"仓库状态"*/
	public void setWarstate(String warstate){
		this.warstate = warstate;
	}
	/**获取"仓库状态"*/
	public String getWarstate(){
		return warstate;
	}
	@Override
	public String toString() {
		return "warehouse[" + 
			"warid = " + warid + 
			", warname = " + warname + 
			", wartype = " + wartype + 
			", warcapacity = " + warcapacity + 
			", waraddress = " + waraddress + 
			", longitude = " + longitude + 
			", latitude = " + latitude + 
			", warstate = " + warstate + 
			"]";
	}
}

