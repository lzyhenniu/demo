package com.pojo;


public class Product {
    int id;//编号
    String name;//商品名称
    String desc;//描述
    double price;//价格
    int num;//库存数量
    String imgUrl;//图片地址
    Company company;//供应商
    Category category;//所属分类

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public com.pojo.Company getCompany() {
        return company;
    }

    public void setCompany(com.pojo.Company company) {
        this.company = company;
    }

    public com.pojo.Category getCategory() {
        return category;
    }

    public void setCategory(com.pojo.Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price='" + price +
                ", num='" + num +
                ", imgUrl='" + imgUrl + '\'' +
                ", company='" + company +
                ", category='" + category +
                '}';
    }
}
