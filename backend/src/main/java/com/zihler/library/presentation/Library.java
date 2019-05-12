package com.zihler.library.presentation;

import com.zihler.library.dataaccess.BookRepository;
import com.zihler.library.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController
@RequestMapping("api/library")
public class Library {

    private BookRepository bookRepository;
    private RentalFactory rentalFactory;

    @Autowired
    public Library(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.rentalFactory = new RentalFactory(bookRepository);
    }

    @GetMapping(value = "/books", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<String[]> getBooks() {
        List<Book> all = this.bookRepository.getAll();
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

    @PostMapping("/fee")
    public List<String> calculateFee(@RequestBody List<String> rentalRequests) {
        String customerName = rentalRequests.remove(0);
        List<Rental> rentals = rentalFactory.createFrom(rentalRequests);

        RentalRecord rentalRecord = new RentalRecord(customerName, rentals);

        Receipt receipt = Receipt.createFor(rentalRecord);

        return List.of(receipt.formatForDisplay());
    }

}

