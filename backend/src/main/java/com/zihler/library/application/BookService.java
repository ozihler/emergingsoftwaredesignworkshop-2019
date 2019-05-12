package com.zihler.library.application;

import com.zihler.library.domain.Book;
import com.zihler.library.domain.Rental;
import com.zihler.library.domain.RentalRecord;
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
        List<Book> all = iRetrieveBooks.getAll();
        ArrayList<String[]> booksAsStringArray = new ArrayList<>();
        for (Book book : all) {
            booksAsStringArray.add(
                    new String[]{
                            Integer.toString(book.getKey()),
                            book.getTitle(),
                            book.getAuthors(),
                            book.getReadingMode(),
                            book.getLink()
                    }
            );
        }
        return booksAsStringArray;
    }

    public List<String> calculateFeeFor(List<String> rentalRequests) {
        String customerName = rentalRequests.remove(0);
        List<Rental> rentals = rentalFactory.createFrom(rentalRequests);

        RentalRecord rentalRecord = new RentalRecord(customerName, rentals);

        Receipt receipt = Receipt.createFor(rentalRecord);

        return List.of(receipt.formatForDisplay());
    }
}
