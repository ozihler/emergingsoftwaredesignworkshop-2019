package com.zihler.download;

public class Pdf {
    boolean isAvailable;

    public Pdf(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Pdf() {
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "{\"isAvailable\" : " + isAvailable + "}";
    }
}
