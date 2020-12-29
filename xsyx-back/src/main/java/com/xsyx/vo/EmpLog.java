package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 表名 :  emp_log<br/>
 * 表注释 : 员工日志表
 */ 
@JsonIgnoreProperties(value = "handler")
public class EmpLog implements Serializable {

	/**id*/
	private Integer id;
	/**员工,外键*/
	private Employee emp;
	/**日志内容*/
	private String content;
	/**附加数据, 可选*/
	private String data;
	/**时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp time;

	public EmpLog() {
		super();
	}
	public EmpLog(Integer id, Employee emp, String content, String data, Timestamp time) {
		this.id = id;
		this.emp = emp;
		this.content = content;
		this.data = data;
		this.time = time;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	public void setEmp(Employee emp){
		this.emp = emp;
	}
	public Employee getEmp(){
		return emp;
	}
	/**设置"日志内容"*/
	public void setContent(String content){
		this.content = content;
	}
	/**获取"日志内容"*/
	public String getContent(){
		return content;
	}
	/**设置"附加数据, 可选"*/
	public void setData(String data){
		this.data = data;
	}
	/**获取"附加数据, 可选"*/
	public String getData(){
		return data;
	}
	/**设置"时间"*/
	public void setTime(Timestamp time){
		this.time = time;
	}
	/**获取"时间"*/
	public Timestamp getTime(){
		return time;
	}
	@Override
	public String toString() {
		return "emp_log[" + 
			"id = " + id + 
			", emp = " + emp + 
			", content = " + content + 
			", data = " + data + 
			", time = " + time + 
			"]";
	}
}

