package com.zihler.library.domain;

public class Book {
    private final int key;
    public final String title;
    public final String authors;
    public final String readingMode;
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
}
