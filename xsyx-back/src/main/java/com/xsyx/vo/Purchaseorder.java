package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;
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
	private String applicant;
	/**申请人备注*/
	private String applicantremarks;
	/**审批人*/
	private String approvedby;
	/**状态, 0未审核，1通过，-1拒绝*/
	private Integer state;
	/**审核人备注*/
	private String approvedbyremarks;
	/**操作时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp operationtime;

	public Purchaseorder() {
	}

	public Purchaseorder(Integer orderid, String applicant, String applicantremarks, String approvedby, Integer state, String approvedbyremarks, Timestamp operationtime) {
		this.orderid = orderid;
		this.applicant = applicant;
		this.applicantremarks = applicantremarks;
		this.approvedby = approvedby;
		this.state = state;
		this.approvedbyremarks = approvedbyremarks;
		this.operationtime = operationtime;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getApplicantremarks() {
		return applicantremarks;
	}

	public void setApplicantremarks(String applicantremarks) {
		this.applicantremarks = applicantremarks;
	}

	public String getApprovedby() {
		return approvedby;
	}

	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getApprovedbyremarks() {
		return approvedbyremarks;
	}

	public void setApprovedbyremarks(String approvedbyremarks) {
		this.approvedbyremarks = approvedbyremarks;
	}

	public Timestamp getOperationtime() {
		return operationtime;
	}

	public void setOperationtime(Timestamp operationtime) {
		this.operationtime = operationtime;
	}

	@Override
	public String toString() {
		return "Purchaseorder{" +
				"orderid=" + orderid +
				", applicant='" + applicant + '\'' +
				", applicantremarks='" + applicantremarks + '\'' +
				", approvedby='" + approvedby + '\'' +
				", state=" + state +
				", approvedbyremarks='" + approvedbyremarks + '\'' +
				", operationtime=" + operationtime +
				'}';
	}
}

