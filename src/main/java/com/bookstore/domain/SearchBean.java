package com.bookstore.domain;

import java.io.Serializable;

public class SearchBean implements Serializable{
    private String sid;
    private String sname;

    public Double getUpprice() {
        return upprice;
    }

    public void setUpprice(Double upprice) {
        this.upprice = upprice;
    }

    public Double getDownprice() {
        return downprice;
    }

    public void setDownprice(Double downprice) {
        this.downprice = downprice;
    }

    private Double upprice;
    private Double downprice;
    private String scategory;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }


    public String getScategory() {
        return scategory;
    }

    public void setScategory(String scategory) {
        this.scategory = scategory;
    }
}
