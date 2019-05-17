package com.zihler.library.application;

import com.zihler.library.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final IRetrieveBooks iRetrieveBooks;
    private final RentalFactory rentalFactory;

    @Autowired
    public BookService(IRetrieveBooks iRetrieveBooks) {
        this.iRetrieveBooks = iRetrieveBooks;
        this.rentalFactory = new RentalFactory(iRetrieveBooks);
    }

    public List<String[]> getAllBooks() {
        Books allBooks = iRetrieveBooks.getAll();
        ArrayList<String[]> booksAsStringArray = new ArrayList<>();
        for (Book book : allBooks) {
            booksAsStringArray.add(
                    new String[]{
                            Integer.toString(book.getKey()),
                            book.getTitle(),
                            book.getAuthors(),
                            book.getReadingMode().name(),
                            book.getImageLink()
                    }
            );
        }
        return booksAsStringArray;
    }

    public List<String> calculateFeeFor(RentalOrder rentalOrder) {
        Rentals rentals = rentalFactory.createFrom(rentalOrder.getRentalRequests());

        RentalRecord rentalRecord = new RentalRecord(rentalOrder.getCustomer(), rentals);

        Receipt receipt = Receipt.createFor(rentalRecord);

        return List.of(receipt.toString());
    }
}
