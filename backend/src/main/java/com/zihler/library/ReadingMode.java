package com.zihler.library;

public enum ReadingMode {
    TEXT, IMAGE, BOTH;


    public static ReadingMode from(String readingMode) {
        return valueOf(readingMode.toUpperCase());
    }
}
