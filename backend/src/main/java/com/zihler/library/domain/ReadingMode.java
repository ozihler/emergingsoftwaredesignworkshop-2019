package com.zihler.library.domain;

public enum ReadingMode {
    TEXT, IMAGE, BOTH;

    public static ReadingMode from(String readingMode) {
        return ReadingMode.valueOf(readingMode.toUpperCase());
    }
}
