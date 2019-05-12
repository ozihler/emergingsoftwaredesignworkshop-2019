package com.zihler.library.domain;

public class Rental {
    private final Book book;
    private final int daysRented;

    public Rental(Book book, int daysRented) {
        this.book = book;
        this.daysRented = daysRented;
    }

    public double getAmount() {
        double amount = 0;
        switch (getBook().getReadingMode()) {
            case "IMAGE":
                amount += 2;
                if (getDaysRented() > 2)
                    amount += (getDaysRented() - 2) * 1.5;
                break;
            case "TEXT":
                amount += 1.5;
                if (getDaysRented() > 3)
                    amount += (getDaysRented() - 3) * 1.5;
                break;
            case "BOTH":
                amount += getDaysRented() * 3;
                break;
        }
        return amount;
    }

    public int getFrequentRenterPoints() {
        // add frequent renter points
       int frequentRenterPoints =  1;

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

    public Book getBook() {
        return book;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
