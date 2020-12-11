package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * 表名 :  menu<br/>
 * 表注释 : 菜单功能表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Menu implements Serializable {

	/**id*/
	private Integer id;
	/**菜单名称*/
	private String name;
	/**访问路径*/
	private String url;
	/**菜单层级*/
	private Integer layer;
	/**功能类型*/
	private String type;
	/**父级菜单*/
	private Menu parent;
	private List<Menu> menus;

	public Menu() {
		super();
	}
	public Menu(Integer id, String name, String url, Integer layer, String type, Menu parent) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.layer = layer;
		this.type = type;
		this.parent = parent;
	}
	public Menu(Integer id, String name, String url, Integer layer, String type, Menu parent, List<Menu> menus) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.layer = layer;
		this.type = type;
		this.parent = parent;
		this.menus = menus;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"菜单名称"*/
	public void setName(String name){
		this.name = name;
	}
	/**获取"菜单名称"*/
	public String getName(){
		return name;
	}
	/**设置"访问路径"*/
	public void setUrl(String url){
		this.url = url;
	}
	/**获取"访问路径"*/
	public String getUrl(){
		return url;
	}
	/**设置"菜单层级"*/
	public void setLayer(Integer layer){
		this.layer = layer;
	}
	/**获取"菜单层级"*/
	public Integer getLayer(){
		return layer;
	}
	/**设置"功能类型"*/
	public void setType(String type){
		this.type = type;
	}
	/**获取"功能类型"*/
	public String getType(){
		return type;
	}
	public void setParent(Menu parent){
		this.parent = parent;
	}
	public Menu getParent(){
		return parent;
	}
	public void setMenus(List<Menu> menus){
		this.menus = menus;
	}
	public List<Menu> getMenus(){
		return menus;
	}
	@Override
	public String toString() {
		return "menu[" + 
			"id = " + id + 
			", name = " + name + 
			", url = " + url + 
			", layer = " + layer + 
			", type = " + type + 
			", parent = " + parent + 
			", menus = " + menus + 
			"]";
	}
}

