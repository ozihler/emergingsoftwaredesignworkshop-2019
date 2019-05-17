package com.zihler.library.domain;

import static com.zihler.library.domain.ReadingMode.BOTH;

public abstract class Rental {
    private  final Book book;
    private final int daysRented;

    Rental(Book book, int daysRented) {
        this.book = book;
        this.daysRented = daysRented;
    }

    public abstract double getAmount();

    int getFrequentRenterPoints() {
        if (book.getReadingMode() == BOTH && daysRented > 1) {
            return 2;
        }

        return 1;
    }

    String getBookName() {
        return book.getTitle();
    }

    String getBookAuthors() {
        return book.getAuthors();
    }

    int getDaysRented() {
        return daysRented;
    }
}
