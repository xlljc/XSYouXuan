package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  permission<br/>
 * 表注释 : 权限表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Permission implements Serializable {

	/**id*/
	private Integer id;
	/**菜单*/
	private Integer menu;
	/**角色*/
	private Integer role;

	public Permission() {
		super();
	}
	public Permission(Integer id,Integer menu,Integer role) {
		this.id = id;
		this.menu = menu;
		this.role = role;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"菜单"*/
	public void setMenu(Integer menu){
		this.menu = menu;
	}
	/**获取"菜单"*/
	public Integer getMenu(){
		return menu;
	}
	/**设置"角色"*/
	public void setRole(Integer role){
		this.role = role;
	}
	/**获取"角色"*/
	public Integer getRole(){
		return role;
	}
	@Override
	public String toString() {
		return "permission[" + 
			"id = " + id + 
			", menu = " + menu + 
			", role = " + role + 
			"]";
	}
}

