package com.zihler.library.domain;

public abstract class Rental {
    private  final Book book;
    private final int daysRented;

    Rental(Book book, int daysRented) {
        this.book = book;
        this.daysRented = daysRented;
    }

    public abstract double getAmount();

    int getFrequentRenterPoints() {
        // add frequent renter points
        int frequentRenterPoints = 1;

        // add bonus for a reading mode "both"
        if (getBook().getReadingMode().equals("BOTH") && getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    public String getBookName() {
        return getBook().getTitle();
    }

    public String getBookAuthors() {
        return getBook().getAuthors();
    }

    private Book getBook() {
        return book;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
