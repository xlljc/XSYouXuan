package com.xsyx.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 表名 :  purchase<br/>
 * 表注释 : 采购表（采购申请记录）
 */
@JsonIgnoreProperties(value = "handler")
public class Purchase implements Serializable {

	/**记录编号*/
	private Integer id;
	/**订单id*/
	private String orderid;
	/**商品id*/
	private String commodityid;
	/**商品名*/
	private String commodityname;
	/**商品价格*/
	private Float price;
	//商品规格
	private String specification;
	/**商品数量*/
	private Integer commoditysum;

	public Purchase() {
	}

	public Purchase(Integer id, String orderid, String commodityid, String commodityname, Float price, String specification, Integer commoditysum) {
		this.id = id;
		this.orderid = orderid;
		this.commodityid = commodityid;
		this.commodityname = commodityname;
		this.price = price;
		this.specification = specification;
		this.commoditysum = commoditysum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid;
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Integer getCommoditysum() {
		return commoditysum;
	}

	public void setCommoditysum(Integer commoditysum) {
		this.commoditysum = commoditysum;
	}

	@Override
	public String toString() {
		return "Purchase{" +
				"id=" + id +
				", orderid='" + orderid + '\'' +
				", commodityid='" + commodityid + '\'' +
				", commodityname='" + commodityname + '\'' +
				", price=" + price +
				", specification='" + specification + '\'' +
				", commoditysum=" + commoditysum +
				'}';
	}
}

