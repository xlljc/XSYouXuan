package com.xsyx.vo;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

import java.util.List;

/**
 * 表名 :  user<br/>
 * 表注释 : 用户表
 */ 
@JsonIgnoreProperties(value = "handler")
public class User implements Serializable {

	/**id*/
	private Integer id;
	/**用户名*/
	private String username;
	/**密码*/
	private String password;
	/**用户头像*/
	private String headPortrait;
	/**用户手机号码*/
	private String phone;
	/**个性签名*/
	private String signature;
	/**生日*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date birthday;
	/**姓名*/
	private String uname;
	/**性别*/
	private String sex;
	/**身份证*/
	private String idCard;
	/**商户id*/
	private Merchants merid;
	/**注销状态*/
	private Integer isdelete;
	private List<Comments> commentss;
	private List<MerchantsApply> merchantsApplys;
	private List<Shopcar> shopcars;
	private List<Star> stars;

	public User() {
		super();
	}
	public User(Integer id,String username,String password,String headPortrait,String phone,String signature,Date birthday,String uname,String sex,String idCard,Merchants merid,Integer isdelete) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.headPortrait = headPortrait;
		this.phone = phone;
		this.signature = signature;
		this.birthday = birthday;
		this.uname = uname;
		this.sex = sex;
		this.idCard = idCard;
		this.merid = merid;
		this.isdelete = isdelete;
	}
	public User(Integer id,String username,String password,String headPortrait,String phone,String signature,Date birthday,String uname,String sex,String idCard,Merchants merid,Integer isdelete,List<Comments> commentss,List<MerchantsApply> merchantsApplys,List<Shopcar> shopcars,List<Star> stars) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.headPortrait = headPortrait;
		this.phone = phone;
		this.signature = signature;
		this.birthday = birthday;
		this.uname = uname;
		this.sex = sex;
		this.idCard = idCard;
		this.merid = merid;
		this.isdelete = isdelete;
		this.commentss = commentss;
		this.merchantsApplys = merchantsApplys;
		this.shopcars = shopcars;
		this.stars = stars;
	}
	/**设置"id"*/
	public void setId(Integer id){
		this.id = id;
	}
	/**获取"id"*/
	public Integer getId(){
		return id;
	}
	/**设置"用户名"*/
	public void setUsername(String username){
		this.username = username;
	}
	/**获取"用户名"*/
	public String getUsername(){
		return username;
	}
	/**设置"密码"*/
	public void setPassword(String password){
		this.password = password;
	}
	/**获取"密码"*/
	public String getPassword(){
		return password;
	}
	/**设置"用户头像"*/
	public void setHeadPortrait(String headPortrait){
		this.headPortrait = headPortrait;
	}
	/**获取"用户头像"*/
	public String getHeadPortrait(){
		return headPortrait;
	}
	/**设置"用户手机号码"*/
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**获取"用户手机号码"*/
	public String getPhone(){
		return phone;
	}
	/**设置"个性签名"*/
	public void setSignature(String signature){
		this.signature = signature;
	}
	/**获取"个性签名"*/
	public String getSignature(){
		return signature;
	}
	/**设置"生日"*/
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	/**获取"生日"*/
	public Date getBirthday(){
		return birthday;
	}
	/**设置"姓名"*/
	public void setUname(String uname){
		this.uname = uname;
	}
	/**获取"姓名"*/
	public String getUname(){
		return uname;
	}
	/**设置"性别"*/
	public void setSex(String sex){
		this.sex = sex;
	}
	/**获取"性别"*/
	public String getSex(){
		return sex;
	}
	/**设置"身份证"*/
	public void setIdCard(String idCard){
		this.idCard = idCard;
	}
	/**获取"身份证"*/
	public String getIdCard(){
		return idCard;
	}
	public void setMerid(Merchants merid){
		this.merid = merid;
	}
	public Merchants getMerid(){
		return merid;
	}
	/**设置"注销状态"*/
	public void setIsdelete(Integer isdelete){
		this.isdelete = isdelete;
	}
	/**获取"注销状态"*/
	public Integer getIsdelete(){
		return isdelete;
	}
	public void setCommentss(List<Comments> commentss){
		this.commentss = commentss;
	}
	public List<Comments> getCommentss(){
		return commentss;
	}
	public void setMerchantsApplys(List<MerchantsApply> merchantsApplys){
		this.merchantsApplys = merchantsApplys;
	}
	public List<MerchantsApply> getMerchantsApplys(){
		return merchantsApplys;
	}
	public void setShopcars(List<Shopcar> shopcars){
		this.shopcars = shopcars;
	}
	public List<Shopcar> getShopcars(){
		return shopcars;
	}
	public void setStars(List<Star> stars){
		this.stars = stars;
	}
	public List<Star> getStars(){
		return stars;
	}
	@Override
	public String toString() {
		return "user[" + 
			"id = " + id + 
			", username = " + username + 
			", password = " + password + 
			", headPortrait = " + headPortrait + 
			", phone = " + phone + 
			", signature = " + signature + 
			", birthday = " + birthday + 
			", uname = " + uname + 
			", sex = " + sex + 
			", idCard = " + idCard + 
			", merid = " + merid + 
			", isdelete = " + isdelete + 
			", commentss = " + commentss + 
			", merchantsApplys = " + merchantsApplys + 
			", shopcars = " + shopcars + 
			", stars = " + stars + 
			"]";
	}
}

