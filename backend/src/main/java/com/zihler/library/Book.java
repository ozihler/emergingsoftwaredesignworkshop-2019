package com.zihler.library;

class Book {
    private final int id;
    private final Title title;
    private final Authors authors;
    private final ReadingMode readingMode;
    private final ImageLink imageLink;

    private Book(String[] book) {
        this(
                Integer.parseInt(book[0]),
                new Title(book[1]),
                Authors.from(book[2]),
                ReadingMode.from(book[3]),
                new ImageLink(book[4])
        );
    }

    private Book(int id, Title title, Authors authors, ReadingMode readingMode, ImageLink imageLink) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.readingMode = readingMode;
        this.imageLink = imageLink;
    }

    static Book from(String bookData) {
        return new Book(bookData.split(";"));
    }

    int getId() {
        return id;
    }

    Title getTitle() {
        return title;
    }

    ReadingMode getReadingMode() {
        return readingMode;
    }

    ImageLink getImageLink() {
        return imageLink;
    }

    Authors getAuthors() {
        return authors;
    }
}
