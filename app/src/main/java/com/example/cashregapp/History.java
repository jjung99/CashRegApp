package com.example.cashregapp;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

public class History implements Serializable {

    //history variables
    private String hName;
    private String hPrice;
    private int hTotalQty;
    private Date hTime;

    public History() { }

    public History(String hName, String hPrice, int hTotalQty, Date hTime){
        this.hName=hName;
        this.hPrice=hPrice;
        this.hTotalQty=hTotalQty;
        this.hTime=hTime;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public void sethPrice(String pPrice) {
        this.hPrice = hPrice;
    }

    public void sethTotalQty(int hTotalQty) {
        this.hTotalQty = hTotalQty;
    }

    public void sethTime(Date hTime){   this.hTime=hTime;}

    public String gethName() { return hName; }

    public String gethPrice() {
        return hPrice;
    }

    public int gethTotalQty() { return hTotalQty; }

    public Date gethTime() {
        return hTime;
    }

}
