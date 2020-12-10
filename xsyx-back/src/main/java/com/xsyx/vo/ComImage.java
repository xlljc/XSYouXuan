package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 表名 :  com_image<br/>
 * 表注释 : 商品图片表
 */ 
@JsonIgnoreProperties(value = "handler")
public class ComImage implements Serializable {

	/**id*/
	private Integer id;
	/**商品id , 外键*/
	private Integer commodity;
	/**路径*/
	private String url;

	public ComImage() {
		super();
	}
	public ComImage(Integer id,Integer commodity,String url) {
		this.id = id;
		this.commodity = commodity;
		this.url = url;
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
	/**设置"路径"*/
	public void setUrl(String url){
		this.url = url;
	}
	/**获取"路径"*/
	public String getUrl(){
		return url;
	}
	@Override
	public String toString() {
		return "com_image[" + 
			"id = " + id + 
			", commodity = " + commodity + 
			", url = " + url + 
			"]";
	}
}

