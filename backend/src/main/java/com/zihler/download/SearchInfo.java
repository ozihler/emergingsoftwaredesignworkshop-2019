package com.zihler.download;

public class SearchInfo {
    String textSnippet;

    public SearchInfo() {
    }

    public SearchInfo(String textSnippet) {
        this.textSnippet = textSnippet;
    }

    public String getTextSnippet() {
        return textSnippet;
    }

    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }

    @Override
    public String toString() {
        return "{\"textSnippet\" : " + textSnippet + "}";
    }
}
