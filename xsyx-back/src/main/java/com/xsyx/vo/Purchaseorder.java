package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

import java.util.List;

/**
 * 表名 :  purchaseorder<br/>
 * 表注释 : 采购订单表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Purchaseorder implements Serializable {

	/**订单id*/
	private Integer orderid;
	/**申请人*/
	private Employee applicant;
	/**申请人备注*/
	private String applicantremarks;
	/**审批人*/
	private Employee approvedby;
	/**状态*/
	private String state;
	/**审核人备注*/
	private String approvedbyremarks;
	/**操作时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp operationtime;
	private List<Purchase> purchases;

	public Purchaseorder() {
		super();
	}
	public Purchaseorder(Integer orderid,Employee applicant,String applicantremarks,Employee approvedby,String state,String approvedbyremarks,Timestamp operationtime) {
		this.orderid = orderid;
		this.applicant = applicant;
		this.applicantremarks = applicantremarks;
		this.approvedby = approvedby;
		this.state = state;
		this.approvedbyremarks = approvedbyremarks;
		this.operationtime = operationtime;
	}
	public Purchaseorder(Integer orderid,Employee applicant,String applicantremarks,Employee approvedby,String state,String approvedbyremarks,Timestamp operationtime,List<Purchase> purchases) {
		this.orderid = orderid;
		this.applicant = applicant;
		this.applicantremarks = applicantremarks;
		this.approvedby = approvedby;
		this.state = state;
		this.approvedbyremarks = approvedbyremarks;
		this.operationtime = operationtime;
		this.purchases = purchases;
	}
	/**设置"订单id"*/
	public void setOrderid(Integer orderid){
		this.orderid = orderid;
	}
	/**获取"订单id"*/
	public Integer getOrderid(){
		return orderid;
	}
	public void setApplicant(Employee applicant){
		this.applicant = applicant;
	}
	public Employee getApplicant(){
		return applicant;
	}
	/**设置"申请人备注"*/
	public void setApplicantremarks(String applicantremarks){
		this.applicantremarks = applicantremarks;
	}
	/**获取"申请人备注"*/
	public String getApplicantremarks(){
		return applicantremarks;
	}
	public void setApprovedby(Employee approvedby){
		this.approvedby = approvedby;
	}
	public Employee getApprovedby(){
		return approvedby;
	}
	/**设置"状态"*/
	public void setState(String state){
		this.state = state;
	}
	/**获取"状态"*/
	public String getState(){
		return state;
	}
	/**设置"审核人备注"*/
	public void setApprovedbyremarks(String approvedbyremarks){
		this.approvedbyremarks = approvedbyremarks;
	}
	/**获取"审核人备注"*/
	public String getApprovedbyremarks(){
		return approvedbyremarks;
	}
	/**设置"操作时间"*/
	public void setOperationtime(Timestamp operationtime){
		this.operationtime = operationtime;
	}
	/**获取"操作时间"*/
	public Timestamp getOperationtime(){
		return operationtime;
	}
	public void setPurchases(List<Purchase> purchases){
		this.purchases = purchases;
	}
	public List<Purchase> getPurchases(){
		return purchases;
	}
	@Override
	public String toString() {
		return "purchaseorder[" + 
			"orderid = " + orderid + 
			", applicant = " + applicant + 
			", applicantremarks = " + applicantremarks + 
			", approvedby = " + approvedby + 
			", state = " + state + 
			", approvedbyremarks = " + approvedbyremarks + 
			", operationtime = " + operationtime + 
			", purchases = " + purchases + 
			"]";
	}
}

