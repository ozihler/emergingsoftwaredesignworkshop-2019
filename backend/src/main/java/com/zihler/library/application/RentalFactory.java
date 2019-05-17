package com.zihler.library.application;

import com.zihler.library.domain.*;

class RentalFactory {
    private IRetrieveBooks iRetrieveBooks;

    RentalFactory(IRetrieveBooks iRetrieveBooks) {
        this.iRetrieveBooks = iRetrieveBooks;
    }

    Rentals createFrom(RentalRequests requests) {
        Rentals rentals = new Rentals();

        requests.getRentalRequests()
                .stream()
                .map(this::createFrom)
                .forEach(rentals::add);

        return rentals;
    }

    private Rental createFrom(String nextRequest) {
        final String[] rentalData = nextRequest.split(" ");

        return create(
                iRetrieveBooks.getByKey(Integer.parseInt(rentalData[0])),
                Integer.parseInt(rentalData[1])
        );
    }

    private static Rental create(Book book, int daysRented) {
        switch (book.getReadingMode()) {
            case IMAGE:
                return new ImageRental(book, daysRented);
            case TEXT:
                return new TextRental(book, daysRented);
            case BOTH:
                return new BothModesRental(book, daysRented);
            default:
                throw new IllegalArgumentException(String.format("Could not find rental type %s", book.getReadingMode().name()));
        }
    }
}
