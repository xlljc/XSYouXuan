package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

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
	/**日志内容, 链接占位符请使用 ${name}*/
	private String content;
	/**链接地址*/
	private String link;
	/**时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp time;

	public EmpLog() {
		super();
	}
	public EmpLog(Integer id,Employee emp,String content,String link,Timestamp time) {
		this.id = id;
		this.emp = emp;
		this.content = content;
		this.link = link;
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
	/**设置"日志内容, 链接占位符请使用 ${name}"*/
	public void setContent(String content){
		this.content = content;
	}
	/**获取"日志内容, 链接占位符请使用 ${name}"*/
	public String getContent(){
		return content;
	}
	/**设置"链接地址"*/
	public void setLink(String link){
		this.link = link;
	}
	/**获取"链接地址"*/
	public String getLink(){
		return link;
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
			", link = " + link + 
			", time = " + time + 
			"]";
	}
}

