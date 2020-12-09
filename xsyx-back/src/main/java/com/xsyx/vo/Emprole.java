package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * 表名 :  emprole<br/>
 * 表注释 : 员工角色表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Emprole implements Serializable {

	/**id*/
	private Integer id;
	/**员工*/
	private Integer employee;
	/**角色*/
	private Integer role;

	public Emprole() {
		super();
	}
	public Emprole(Integer id,Integer employee,Integer role) {
		this.id = id;
		this.employee = employee;
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
	/**设置"员工"*/
	public void setEmployee(Integer employee){
		this.employee = employee;
	}
	/**获取"员工"*/
	public Integer getEmployee(){
		return employee;
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
		return "emprole[" + 
			"id = " + id + 
			", employee = " + employee + 
			", role = " + role + 
			"]";
	}
}

