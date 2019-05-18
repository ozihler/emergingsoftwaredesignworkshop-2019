package com.zihler.library;

import static com.zihler.library.ReadingMode.BOTH;

class Rental {
    private Book book;
    private int daysRented;

    Rental(Book book, int daysRented) {
        this.book = book;
        this.daysRented = daysRented;
    }

    Book getBook() {
        return book;
    }

    int getDaysRented() {
        return daysRented;
    }

    double getAmount() {
        double thisAmount = 0;
        switch (getBook().getReadingMode()) {
            case IMAGE:
                thisAmount += 2;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() - 2) * 1.5;
                break;
            case TEXT:
                thisAmount += 1.5;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() - 3) * 1.5;
                break;
            case BOTH:
                thisAmount += getDaysRented() * 3;
                break;
        }
        return thisAmount;
    }

    int getFrequentRenterPoints() {
        if (getBook().getReadingMode() == BOTH && getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }
}
