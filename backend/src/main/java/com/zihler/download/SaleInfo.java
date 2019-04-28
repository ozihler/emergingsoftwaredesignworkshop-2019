package com.zihler.download;

public class SaleInfo {
    String country;
    String saleability;
    boolean isEbook;

    public SaleInfo() {
    }

    public SaleInfo(String country, String saleability, boolean isEbook) {
        this.country = country;
        this.saleability = saleability;
        this.isEbook = isEbook;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSaleability() {
        return saleability;
    }

    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    public boolean isEbook() {
        return isEbook;
    }

    public void setEbook(boolean ebook) {
        isEbook = ebook;
    }

    @Override
    public String toString() {
        return String.format("{\"country\" : %s,\"saleability\" : %s,\"isEbook\" : %s}", country, saleability, isEbook);
    }
}
