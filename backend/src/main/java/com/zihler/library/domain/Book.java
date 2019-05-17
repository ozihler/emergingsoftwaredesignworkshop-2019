package com.zihler.library.domain;

public class Book {
    private final int key;
    private final String title;
    private final String authors;
    private final ReadingMode readingMode;
    private final String imageLink;

    private Book(int key, String title, String authors, ReadingMode readingMode, String imageLink) {
        this.key = key;
        this.title = title;
        this.authors = authors;
        this.readingMode = readingMode;
        this.imageLink = imageLink;
    }

    private static Book from(String[] book) {
        return new Book(
                Integer.parseInt(book[0]),
                book[1],
                book[2],
                ReadingMode.from(book[3]),
                book[4]
        );
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

    public ReadingMode getReadingMode() {
        return readingMode;
    }

    public String getImageLink() {
        return imageLink;
    }
}
