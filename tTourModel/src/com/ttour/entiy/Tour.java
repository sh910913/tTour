/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttour.entiy;

/**
 *
 * @author Owner
 */
public class Tour {

    /**
     * 自動編號
     */
    private int id;
    private String name;
    private int price;
    /**
     * 所屬地區
     */
    private String area;
    /**
     * 類型
     */
    private String type;
    private String photo1;
    private String photo2;
    private String photo3;
    private String photo4;
    /**
     * 導覽介紹
     */
    private String introduce;
    /**
     * 預定須知
     */
    private String purchase;
    /**
     * 費用說明
     */
    private String cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getPhoto4() {
        return photo4;
    }

    public void setPhoto4(String photo4) {
        this.photo4 = photo4;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPurchase() {
        return purchase;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tour other = (Tour) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "\n"+"編號:" + id +"\n"+ "姓名:" + name +"\n"+"價格:" + price + "\n"
                + "地區:" + area +"\n"+ "類型:" + type + ", photo1=" + photo1 + ", photo2="
                + photo2 + ", photo3=" + photo3 + ", photo4=" + photo4 + ", introduce=" + introduce + "\n"
                + "預定須知:" + purchase +"\n"+ "費用說明:" + cost ;
    }

}
