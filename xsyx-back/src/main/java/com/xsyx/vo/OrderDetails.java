package com.xsyx.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * 衍生类, 商品订单详情类
 */
@JsonIgnoreProperties(value = "handler")
public class OrderDetails implements Serializable {

    private Integer id;
    private String orderNumber;
    private Integer ordstate;
    private Float totlemoney;
    private String commodityName;
    private String commodityImage;
    private String typeName;
    private String number;
    private String username;
    private String uname;
    private String phone;
    private Date deliveryTime;
    private Date pickUpTime;
    private Integer merid;
    private String merName;
    private String address;
    private String merPhone;

    public OrderDetails() {}

    public OrderDetails(Integer id, String orderNumber, Integer ordstate, Float totlemoney, String commodityName, String commodityImage, String typeName, String number, String username, String uname, String phone, Date deliveryTime, Date pickUpTime, Integer merid, String merName, String address, String merPhone) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.ordstate = ordstate;
        this.totlemoney = totlemoney;
        this.commodityName = commodityName;
        this.commodityImage = commodityImage;
        this.typeName = typeName;
        this.number = number;
        this.username = username;
        this.uname = uname;
        this.phone = phone;
        this.deliveryTime = deliveryTime;
        this.pickUpTime = pickUpTime;
        this.merid = merid;
        this.merName = merName;
        this.address = address;
        this.merPhone = merPhone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrdstate() {
        return ordstate;
    }

    public void setOrdstate(Integer ordstate) {
        this.ordstate = ordstate;
    }

    public Float getTotlemoney() {
        return totlemoney;
    }

    public void setTotlemoney(Float totlemoney) {
        this.totlemoney = totlemoney;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityImage() {
        return commodityImage;
    }

    public void setCommodityImage(String commodityImage) {
        this.commodityImage = commodityImage;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public Integer getMerid() {
        return merid;
    }

    public void setMerid(Integer merid) {
        this.merid = merid;
    }

    public String getMerName() {
        return merName;
    }

    public void setMerName(String merName) {
        this.merName = merName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMerPhone() {
        return merPhone;
    }

    public void setMerPhone(String merPhone) {
        this.merPhone = merPhone;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", ordstate=" + ordstate +
                ", totlemoney=" + totlemoney +
                ", commodityName='" + commodityName + '\'' +
                ", commodityImage='" + commodityImage + '\'' +
                ", typeName='" + typeName + '\'' +
                ", number='" + number + '\'' +
                ", username='" + username + '\'' +
                ", uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", pickUpTime=" + pickUpTime +
                ", merid=" + merid +
                ", merName='" + merName + '\'' +
                ", address='" + address + '\'' +
                ", merPhone='" + merPhone + '\'' +
                '}';
    }
}
