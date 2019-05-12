package com.zihler.library.domain;

public class TextRental extends Rental {
    TextRental(Book book, int daysRented) {
        super(book, daysRented);
    }

    @Override
    public double getAmount() {
        if (getDaysRented() > 3) {
            return getDaysRented() * 1.5 - 3;
        }

        return 1.5;
    }
}
