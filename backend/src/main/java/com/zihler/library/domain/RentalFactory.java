package com.zihler.library.domain;

import com.zihler.library.dataaccess.BookRepository;

public class RentalFactory {
    private BookRepository bookRepository;

    public RentalFactory(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Rental createFrom(String nextRequest) {
        final String[] rentalData = nextRequest.split(" ");

        return new Rental(
                bookRepository.getByKey(Integer.parseInt(rentalData[0])),
                Integer.parseInt(rentalData[1])
        );
    }
}
