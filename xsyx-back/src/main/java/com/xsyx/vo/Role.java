package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 表名 :  role<br/>
 * 表注释 : 角色表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Role implements Serializable {

	/**id*/
	private Integer id;
	/**角色名称*/
	private String name;
	/**角色备注*/
	private String remark;

	public Role() {
		super();
	}
	public Role(Integer id,String name,String remark) {
		this.id = id;
		this.name = name;
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
	/**设置"角色名称"*/
	public void setName(String name){
		this.name = name;
	}
	/**获取"角色名称"*/
	public String getName(){
		return name;
	}
	/**设置"角色备注"*/
	public void setRemark(String remark){
		this.remark = remark;
	}
	/**获取"角色备注"*/
	public String getRemark(){
		return remark;
	}
	@Override
	public String toString() {
		return "role[" + 
			"id = " + id + 
			", name = " + name + 
			", remark = " + remark + 
			"]";
	}
}

