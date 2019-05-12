package com.zihler.library.domain;

import com.zihler.library.dataaccess.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class RentalFactory {
    private BookRepository bookRepository;

    public RentalFactory(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Rental> createFrom(List<String> rentalRequests) {
        List<Rental> rentals = new ArrayList<>();
        for (int i = 0; i < rentalRequests.size(); i++) {
            rentals.add(createFrom(rentalRequests.get(i)));
        }
        return rentals;
    }

    private Rental createFrom(String nextRequest) {
        final String[] rentalData = nextRequest.split(" ");

        return create(
                bookRepository.getByKey(Integer.parseInt(rentalData[0])),
                Integer.parseInt(rentalData[1])
        );
    }

    private static Rental create(Book book, int daysRented) {
        switch (book.getReadingMode()) {
            case "IMAGE":
                return new ImageRental(book, daysRented);
            case "TEXT":
                return new TextRental(book, daysRented);
            case "BOTH":
                return new AllModesRental(book, daysRented);
            default:
                throw new IllegalArgumentException(String.format("Could not find rental type %s", book.getReadingMode()));
        }
    }
}
