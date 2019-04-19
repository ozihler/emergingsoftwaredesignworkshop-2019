package com.zihler.download;

public class IndustryIdentifiers {
    String type;
    String identifier;

    public IndustryIdentifiers(String type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public IndustryIdentifiers() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
