package com.xsyx.vo;
//仓库存储商品实体
public class WareHouseStorage {
    String warid;
    String warname;
    Integer id;
    String name;
    Integer number;
    String specification;

    public WareHouseStorage() {
    }

    public WareHouseStorage(String warid, String warname, Integer id, String name, Integer number, String specification) {
        this.warid = warid;
        this.warname = warname;
        this.id = id;
        this.name = name;
        this.number = number;
        this.specification = specification;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getWarname() {
        return warname;
    }

    public void setWarname(String warname) {
        this.warname = warname;
    }

    public String getWarid() {
        return warid;
    }

    public void setWarid(String warid) {
        this.warid = warid;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "WareHouseStorage{" +
                "warid='" + warid + '\'' +
                ", warname='" + warname + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", specification='" + specification + '\'' +
                '}';
    }
}
