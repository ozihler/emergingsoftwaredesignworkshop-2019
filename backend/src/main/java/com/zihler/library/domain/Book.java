package com.zihler.library.domain;

public class Book {
    private final int key;
    private final String title;
    private final String authors;
    private final String readingMode;
    private final String link;

    private Book(int key, String title, String authors, String readingMode, String link) {
        this.key = key;
        this.title = title;
        this.authors = authors;
        this.readingMode = readingMode;
        this.link = link;
    }

    private static Book from(String[] book) {
        return new Book(Integer.parseInt(book[0]), book[1], book[2], book[3], book[4]);
    }

    public static Book from(String line) {
        return from(line.split(";"));
    }

    public int getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getReadingMode() {
        return readingMode;
    }

    public String getLink() {
        return link;
    }
}
