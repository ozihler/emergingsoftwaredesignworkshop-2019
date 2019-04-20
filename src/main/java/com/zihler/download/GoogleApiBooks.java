package com.zihler.download;

import java.util.List;

public class GoogleApiBooks {
    private String kind;
    private int totalItems;
    private List<Item> items;

    public GoogleApiBooks() {
    }

    public GoogleApiBooks(String kind, int totalItems, List<Item> items) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return "{\"kind\" : " + (kind == null ? null : "\"" + kind + "\"") + ",\"totalItems\" : " + totalItems + ",\"items\" : " + (items == null ? null : items) + "}";
    }
}
