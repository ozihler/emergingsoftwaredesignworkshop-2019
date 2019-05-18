package com.zihler.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class RentalFactory {
    private BookRepository bookRepository;

    @Autowired
    public RentalFactory(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    List<Rental> createFrom(List<String> rentalRequests) {
        return rentalRequests.stream()
                .map(this::createFrom)
                .collect(toList());
    }

    private Rental createFrom(String rental) {
        final String[] rentalData = rental.split(" ");
        return new Rental(bookRepository.findByKey(Integer.parseInt(rentalData[0])), Integer.parseInt(rentalData[1]));
    }
}
