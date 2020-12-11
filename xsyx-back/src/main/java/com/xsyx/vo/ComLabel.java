package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 表名 :  com_label<br/>
 * 表注释 : 商品标签表
 */ 
@JsonIgnoreProperties(value = "handler")
public class ComLabel implements Serializable {

	/**id*/
	private Integer id;
	/**标签名称*/
	private String name;

	public ComLabel() {
		super();
	}
	public ComLabel(Integer id,String name) {
		this.id = id;
		this.name = name;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"标签名称"*/
	public void setName(String name){
		this.name = name;
	}
	/**获取"标签名称"*/
	public String getName(){
		return name;
	}
	@Override
	public String toString() {
		return "com_label[" + 
			"id = " + id + 
			", name = " + name + 
			"]";
	}
}

