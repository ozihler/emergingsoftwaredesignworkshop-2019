package com.zihler.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class RentalService {
    private BookRepository bookRepository;
    private RentalFactory rentalFactory;

    @Autowired
    public RentalService(BookRepository bookRepository, RentalFactory rentalFactory) {
        this.bookRepository = bookRepository;
        this.rentalFactory = rentalFactory;
    }

    private static String[] asStringArray(Book book) {
        return new String[]{
                Integer.toString(book.getId()),
                book.getTitle().toString(),
                book.getAuthors().toString(),
                book.getReadingMode().name(),
                book.getImageLink().toString()
        };
    }

    List<String[]> getAll() {
        return bookRepository.getAll()
                .stream()
                .map(RentalService::asStringArray)
                .collect(toList());
    }

    List<String> calculateFeeFor(List<String> rentalRequests) {
        Customer customer = new Customer(rentalRequests.remove(0));

        List<Rental> rentals = this.rentalFactory.createFrom(rentalRequests);

        RentalRecord rentalRecord = new RentalRecord(customer, rentals);

        Receipt receipt = new Receipt(rentalRecord);

        String result = receipt.toString();

        return List.of(result);
    }
}
