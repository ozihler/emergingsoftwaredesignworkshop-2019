package com.zihler.library.domain;

import com.zihler.library.dataaccess.BookRepository;

import java.util.ArrayList;
import java.util.List;

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

    public List<Rental> createFrom(List<String> rentalRequests) {
        List<Rental> rentals = new ArrayList<>();
        for (int i = 0; i < rentalRequests.size(); i++) {
            rentals.add(createFrom(rentalRequests.get(i)));
        }
        return rentals;
    }
}
