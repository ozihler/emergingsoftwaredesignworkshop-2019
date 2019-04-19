package com.zihler.download;

public class Epub {
    boolean isAvailable;

    public Epub(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Epub() {
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
