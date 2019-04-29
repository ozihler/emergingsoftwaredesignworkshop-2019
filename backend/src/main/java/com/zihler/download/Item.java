package com.zihler.download;

public class Item {
    String kind;
    String id;
    String etag;
    String selfLink;
    VolumeInfo volumeInfo;
    SaleInfo saleInfo;
    AccessInfo accessInfo;
    SearchInfo searchInfo;

    public Item() {
    }

    public Item(String kind, String id, String etag, String selfLink, VolumeInfo volumeInfo, SaleInfo saleInfo, AccessInfo accessInfo, SearchInfo searchInfo) {
        this.kind = kind;
        this.id = id;
        this.etag = etag;
        this.selfLink = selfLink;
        this.volumeInfo = volumeInfo;
        this.saleInfo = saleInfo;
        this.accessInfo = accessInfo;
        this.searchInfo = searchInfo;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(SaleInfo saleInfo) {
        this.saleInfo = saleInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    public void setAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }

    public SearchInfo getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(SearchInfo searchInfo) {
        this.searchInfo = searchInfo;
    }

    @Override
    public String toString() {
        return "{\"kind\" : " + (kind == null ? null : kind) + ",\"id\" : " + (id == null ? null : id) + ",\"etag\" : " + (etag == null ? null : etag) + ",\"selfLink\" : " + (selfLink == null ? null : selfLink) + ",\"volumeInfo\" : " + (volumeInfo == null ? null : volumeInfo) + ",\"saleInfo\" : " + (saleInfo == null ? null : saleInfo) + ",\"accessInfo\" : " + (accessInfo == null ? null : accessInfo) + ",\"searchInfo\" : " + (searchInfo == null ? null : searchInfo) + "}";
    }

    boolean hasAverageRating() {
        return getVolumeInfo().getAverageRating() > 0;
    }
}
