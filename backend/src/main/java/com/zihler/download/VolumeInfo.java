package com.zihler.download;

import java.util.List;

public class VolumeInfo {
    String title;
    List<String> authors;
    String publisher;
    String publishDate;
    String description;
    List<IndustryIdentifiers> industryIdentifiers;
    ReadingModes readingModes;
    int pageCount;
    String printType;
    List<String> categories;
    double averageRating;
    int ratingsCount;
    String maturityRating;
    boolean AllowAnonLogging;
    String contentVersion;
    ImageLinks imageLinks;
    String language;
    String previewLink;
    String infoLink;
    String canonicalVolumeLink;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IndustryIdentifiers> getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public void setIndustryIdentifiers(List<IndustryIdentifiers> industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    public ReadingModes getReadingModes() {
        return readingModes;
    }

    public void setReadingModes(ReadingModes readingModes) {
        this.readingModes = readingModes;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public boolean isAllowAnonLogging() {
        return AllowAnonLogging;
    }

    public void setAllowAnonLogging(boolean allowAnonLogging) {
        AllowAnonLogging = allowAnonLogging;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

    public void setCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    public VolumeInfo() {
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public VolumeInfo(String title, List<String> authors, String publisher, String publishDate, String description, List<IndustryIdentifiers> industryIdentifiers, ReadingModes readingModes, int pageCount, String printType, List<String> categories, Double averageRating, Integer ratingsCount, String maturityRating, boolean allowAnonLogging, String contentVersion, ImageLinks imageLinks, String language, String previewLink, String infoLink, String canonicalVolumeLink) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.description = description;
        this.industryIdentifiers = industryIdentifiers;
        this.readingModes = readingModes;
        this.pageCount = pageCount;
        this.printType = printType;
        this.categories = categories;
        this.averageRating = averageRating;
        this.ratingsCount = ratingsCount;
        this.maturityRating = maturityRating;
        AllowAnonLogging = allowAnonLogging;
        this.contentVersion = contentVersion;
        this.imageLinks = imageLinks;
        this.language = language;
        this.previewLink = previewLink;
        this.infoLink = infoLink;
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    @Override
    public String toString() {
        return String.format("{\"title\" : %s,\"authors\" : %s,\"publisher\" : %s,\"publishDate\" : %s,\"description\" : %s,\"industryIdentifiers\" : %s,\"readingModes\" : %s,\"pageCount\" : %d,\"printType\" : %s,\"categories\" : %s,\"maturityRating\" : %s,\"AllowAnonLogging\" : %s,\"contentVersion\" : %s,\"imageLinks\" : %s,\"language\" : %s,\"previewLink\" : %s,\"infoLink\" : %s,\"canonicalVolumeLink\" : %s}", title, authors, publisher, publishDate, description, industryIdentifiers, readingModes, pageCount, printType, categories, maturityRating, AllowAnonLogging, contentVersion, imageLinks, language, previewLink, infoLink, canonicalVolumeLink);
    }
}
