package com.zihler.library.domain;

public class BothModesRental extends Rental {
    public BothModesRental(Book book, int daysRented) {
        super(book, daysRented);
    }

    @Override
    public double getAmount() {
        return getDaysRented() * 3;
    }
}
