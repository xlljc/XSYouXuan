package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
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
	/**最后一次登录时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Timestamp lastLoginTime;
	/**注销状态, 0注销, 1正常*/
	private Integer isDelete;
	private List<Comments> commentss;
	private List<Information> informations;
	private List<LookHistory> lookHistorys;
	private List<MerLog> merLogs;
	private List<MerchantsApply> merchantsApplys;
	private List<PickupMerchants> pickupMerchantss;
	private List<SearchRecord> searchRecords;
	private List<Shopcar> shopcars;
	private List<Star> stars;
	private List<UserLog> userLogs;

	public User() {
		super();
	}
	public User(Integer id, String username, String password, String headPortrait, String phone, String signature, Date birthday, String uname, String sex, String idCard, Merchants merid, Timestamp lastLoginTime, Integer isDelete) {
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
		this.lastLoginTime = lastLoginTime;
		this.isDelete = isDelete;
	}
	public User(Integer id, String username, String password, String headPortrait, String phone, String signature, Date birthday, String uname, String sex, String idCard, Merchants merid, Timestamp lastLoginTime, Integer isDelete, List<Comments> commentss, List<Information> informations, List<LookHistory> lookHistorys, List<MerLog> merLogs, List<MerchantsApply> merchantsApplys, List<PickupMerchants> pickupMerchantss, List<SearchRecord> searchRecords, List<Shopcar> shopcars, List<Star> stars, List<UserLog> userLogs) {
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
		this.lastLoginTime = lastLoginTime;
		this.isDelete = isDelete;
		this.commentss = commentss;
		this.informations = informations;
		this.lookHistorys = lookHistorys;
		this.merLogs = merLogs;
		this.merchantsApplys = merchantsApplys;
		this.pickupMerchantss = pickupMerchantss;
		this.searchRecords = searchRecords;
		this.shopcars = shopcars;
		this.stars = stars;
		this.userLogs = userLogs;
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
	/**设置"最后一次登录时间"*/
	public void setLastLoginTime(Timestamp lastLoginTime){
		this.lastLoginTime = lastLoginTime;
	}
	/**获取"最后一次登录时间"*/
	public Timestamp getLastLoginTime(){
		return lastLoginTime;
	}
	/**设置"注销状态, 0注销, 1正常"*/
	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}
	/**获取"注销状态, 0注销, 1正常"*/
	public Integer getIsDelete(){
		return isDelete;
	}
	public void setCommentss(List<Comments> commentss){
		this.commentss = commentss;
	}
	public List<Comments> getCommentss(){
		return commentss;
	}
	public void setInformations(List<Information> informations){
		this.informations = informations;
	}
	public List<Information> getInformations(){
		return informations;
	}
	public void setLookHistorys(List<LookHistory> lookHistorys){
		this.lookHistorys = lookHistorys;
	}
	public List<LookHistory> getLookHistorys(){
		return lookHistorys;
	}
	public void setMerLogs(List<MerLog> merLogs){
		this.merLogs = merLogs;
	}
	public List<MerLog> getMerLogs(){
		return merLogs;
	}
	public void setMerchantsApplys(List<MerchantsApply> merchantsApplys){
		this.merchantsApplys = merchantsApplys;
	}
	public List<MerchantsApply> getMerchantsApplys(){
		return merchantsApplys;
	}
	public void setPickupMerchantss(List<PickupMerchants> pickupMerchantss){
		this.pickupMerchantss = pickupMerchantss;
	}
	public List<PickupMerchants> getPickupMerchantss(){
		return pickupMerchantss;
	}
	public void setSearchRecords(List<SearchRecord> searchRecords){
		this.searchRecords = searchRecords;
	}
	public List<SearchRecord> getSearchRecords(){
		return searchRecords;
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
	public void setUserLogs(List<UserLog> userLogs){
		this.userLogs = userLogs;
	}
	public List<UserLog> getUserLogs(){
		return userLogs;
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
			", lastLoginTime = " + lastLoginTime + 
			", isDelete = " + isDelete + 
			", commentss = " + commentss + 
			", informations = " + informations + 
			", lookHistorys = " + lookHistorys + 
			", merLogs = " + merLogs + 
			", merchantsApplys = " + merchantsApplys + 
			", pickupMerchantss = " + pickupMerchantss + 
			", searchRecords = " + searchRecords + 
			", shopcars = " + shopcars + 
			", stars = " + stars + 
			", userLogs = " + userLogs + 
			"]";
	}
}

