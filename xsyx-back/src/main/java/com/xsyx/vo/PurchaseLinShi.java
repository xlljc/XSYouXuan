package com.xsyx.vo;

//临时采购表（用来管理采购了什么商品）
public class PurchaseLinShi {

    //商品id;
    Integer id;
    //商品名
    String name;
    //商品价格
    Float price;
    //商品规格
    String  specification;
    //采购数量
    Integer caigousum;

    public PurchaseLinShi() {
    }

    public PurchaseLinShi(Integer id, String name, Float price, String specification, Integer caigousum) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.specification = specification;
        this.caigousum = caigousum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCaigousum() {
        return caigousum;
    }

    public void setCaigousum(Integer caigousum) {
        this.caigousum = caigousum;
    }

    @Override
    public String toString() {
        return "PurchaseLinShi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", specification='" + specification + '\'' +
                ", caigousum=" + caigousum +
                '}';
    }
}
