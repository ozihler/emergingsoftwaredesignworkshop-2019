package com.zihler.library.domain;

public class ImageRental extends Rental {
    public ImageRental(Book book, int daysRented) {
        super(book, daysRented);
    }

    @Override
    public double getAmount() {
        if (getDaysRented() > 2) {
            return 1.5 * getDaysRented() - 1.0;
        }

        return 2;
    }
}
