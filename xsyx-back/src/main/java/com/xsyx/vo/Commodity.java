package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 表名 :  commodity<br/>
 * 表注释 : 商品表
 */ 
@JsonIgnoreProperties(value = "handler")
public class Commodity implements Serializable {

	/**id*/
	private Integer id;
	/**商品名称*/
	private String name;
	/**商品描述*/
	private String particulars;
	/**商品图片*/
	private String image;
	/**商品价格*/
	private Float price;
	/**单位*/
	private String unit;
	/**规格*/
	private String specification;
	/**生产厂商*/
	private String manufacturer;
	/**商品类型 , 外键*/
	private ComType comType;
	/**商品上架时间(第一次上架时间)*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date putawayDate;
	/**最新上架时间*/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date newestPutawayDate;
	/**商品状态, 0未上架, 1已上架, -1已删除*/
	private Integer state;
	/**商品折扣表, 扩展列*/
	private ComDiscount comDiscount;

	private List<Collect> collects;
	private List<Comments> commentss;
	private List<LookHistory> lookHistorys;
	private List<Purchase> purchases;
	private List<Shopcar> shopcars;
	private List<Star> stars;

	public Commodity() {
		super();
	}
	public Commodity(Integer id, String name, String particulars, Float price, String unit, String specification, String manufacturer, ComType comType, Date putawayDate, Date newestPutawayDate, Integer state) {
		this.id = id;
		this.name = name;
		this.particulars = particulars;
		this.price = price;
		this.unit = unit;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.comType = comType;
		this.putawayDate = putawayDate;
		this.newestPutawayDate = newestPutawayDate;
		this.state = state;
	}
	public Commodity(Integer id, String name, String particulars, Float price, String unit, String specification, String manufacturer, ComType comType, Date putawayDate, Date newestPutawayDate, Integer state, List<Collect> collects, List<Comments> commentss, List<LookHistory> lookHistorys, List<Purchase> purchases, List<Shopcar> shopcars, List<Star> stars) {
		this.id = id;
		this.name = name;
		this.particulars = particulars;
		this.price = price;
		this.unit = unit;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.comType = comType;
		this.putawayDate = putawayDate;
		this.newestPutawayDate = newestPutawayDate;
		this.state = state;
		this.collects = collects;
		this.commentss = commentss;
		this.lookHistorys = lookHistorys;
		this.purchases = purchases;
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
	/**设置"商品名称"*/
	public void setName(String name){
		this.name = name;
	}
	/**获取"商品名称"*/
	public String getName(){
		return name;
	}
	/**设置"商品描述"*/
	public void setParticulars(String particulars){
		this.particulars = particulars;
	}
	/**获取"商品描述"*/
	public String getParticulars(){
		return particulars;
	}
	/**设置"商品价格"*/
	public void setPrice(Float price){
		this.price = price;
	}
	/**获取"商品价格"*/
	public Float getPrice(){
		return price;
	}
	/**设置"单位"*/
	public void setUnit(String unit){
		this.unit = unit;
	}
	/**获取"单位"*/
	public String getUnit(){
		return unit;
	}
	/**设置"规格"*/
	public void setSpecification(String specification){
		this.specification = specification;
	}
	/**获取"规格"*/
	public String getSpecification(){
		return specification;
	}
	/**设置"生产厂商"*/
	public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
	}
	/**获取"生产厂商"*/
	public String getManufacturer(){
		return manufacturer;
	}
	public void setComType(ComType comType){
		this.comType = comType;
	}
	public ComType getComType(){
		return comType;
	}
	/**设置"商品上架时间(第一次上架时间)"*/
	public void setPutawayDate(Date putawayDate){
		this.putawayDate = putawayDate;
	}
	/**获取"商品上架时间(第一次上架时间)"*/
	public Date getPutawayDate(){
		return putawayDate;
	}
	/**设置"最新上架时间"*/
	public void setNewestPutawayDate(Date newestPutawayDate){
		this.newestPutawayDate = newestPutawayDate;
	}
	/**获取"最新上架时间"*/
	public Date getNewestPutawayDate(){
		return newestPutawayDate;
	}
	/**设置"商品状态, 0未上架, 1已上架, -1已删除"*/
	public void setState(Integer state){
		this.state = state;
	}
	/**获取"商品状态, 0未上架, 1已上架, -1已删除"*/
	public Integer getState(){
		return state;
	}
	/**获取"商品折扣表, 扩展列"*/
	public ComDiscount getComDiscount() {
		return comDiscount;
	}
	/**获取"商品折扣表, 扩展列"*/
	public void setComDiscount(ComDiscount comDiscount) {
		this.comDiscount = comDiscount;
	}
	/**获取"商品图片"*/
	public String getImage() {
		return image;
	}
	/**设置"商品图片"*/
	public void setImage(String image) {
		this.image = image;
	}

	public void setCollects(List<Collect> collects){
		this.collects = collects;
	}
	public List<Collect> getCollects(){
		return collects;
	}
	public void setCommentss(List<Comments> commentss){
		this.commentss = commentss;
	}
	public List<Comments> getCommentss(){
		return commentss;
	}
	public void setLookHistorys(List<LookHistory> lookHistorys){
		this.lookHistorys = lookHistorys;
	}
	public List<LookHistory> getLookHistorys(){
		return lookHistorys;
	}
	public void setPurchases(List<Purchase> purchases){
		this.purchases = purchases;
	}
	public List<Purchase> getPurchases(){
		return purchases;
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
		return "commodity[" + 
			"id = " + id + 
			", name = " + name + 
			", particulars = " + particulars + 
			", image = " + image +
			", price = " + price +
			", unit = " + unit + 
			", specification = " + specification + 
			", manufacturer = " + manufacturer + 
			", comType = " + comType + 
			", putawayDate = " + putawayDate + 
			", newestPutawayDate = " + newestPutawayDate + 
			", state = " + state + 
			", collects = " + collects + 
			", commentss = " + commentss + 
			", lookHistorys = " + lookHistorys + 
			", purchases = " + purchases + 
			", shopcars = " + shopcars + 
			", stars = " + stars + 
			", comDiscount = " + comDiscount +
			"]";
	}
}

