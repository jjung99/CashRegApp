package com.example.cashregapp;

public class Product {

    //product variables
    private String pName;
    private String pPrice;
    private int pTotalQty;

    public Product() { }

    public Product(String pName, String pPrice, int pTotalQty){
        this.pName=pName;
        this.pPrice=pPrice;
        this.pTotalQty=pTotalQty;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public void setpTotalQty(int pTotalQty) {
        this.pTotalQty = pTotalQty;
    }

    public String getpName() { return pName; }

    public String getpPrice() {
        return pPrice;
    }

    public int getpTotalQty() { return pTotalQty; }

}
