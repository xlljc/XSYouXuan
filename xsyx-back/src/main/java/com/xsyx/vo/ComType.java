package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * 表名 :  com_type<br/>
 * 表注释 : 商品类型表
 */ 
@JsonIgnoreProperties(value = "handler")
public class ComType implements Serializable {

	/**id*/
	private Integer id;
	/**类型名称*/
	private String name;
	private List<Commodity> commoditys;

	public ComType() {
		super();
	}
	public ComType(Integer id,String name) {
		this.id = id;
		this.name = name;
	}
	public ComType(Integer id,String name,List<Commodity> commoditys) {
		this.id = id;
		this.name = name;
		this.commoditys = commoditys;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"类型名称"*/
	public void setName(String name){
		this.name = name;
	}
	/**获取"类型名称"*/
	public String getName(){
		return name;
	}
	public void setCommoditys(List<Commodity> commoditys){
		this.commoditys = commoditys;
	}
	public List<Commodity> getCommoditys(){
		return commoditys;
	}
	@Override
	public String toString() {
		return "com_type[" + 
			"id = " + id + 
			", name = " + name + 
			", commoditys = " + commoditys + 
			"]";
	}
}

