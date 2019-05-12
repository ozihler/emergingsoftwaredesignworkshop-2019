package com.zihler.library.domain;

public class AllModesRental extends Rental {
    public AllModesRental(Book book, int daysRented) {
        super(book, daysRented);
    }

    @Override
    public double getAmount() {
        return getDaysRented() * 3;
    }
}
