package com.zihler.library;

import com.zihler.library.dataaccess.BookRepository;
import com.zihler.library.domain.Book;
import com.zihler.library.domain.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController
@RequestMapping("api/library")
public class Library {

    private BookRepository bookRepository;

    @Autowired
    public Library(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + customerName + "\n";

        for (int i = 0; i < rentalRequests.size(); i++) {
            String nextRequest = rentalRequests.get(i);
            final String[] rentalData = nextRequest.split(" ");

            Rental rental = new Rental(
                    bookRepository.getByKey(Integer.parseInt(rentalData[0])),
                    Integer.parseInt(rentalData[1])
            );

            frequentRenterPoints += rental.getFrequentRenterPoints();

            // create figures for this rental
            result += "\t'" + rental.getBookName()
                    + "' by '" + rental.getBookAuthors()
                    + "' for " + rental.getDaysRented()
                    + " days: \t"
                    + rental.getAmount()
                    + " $\n";

            totalAmount += rental.getAmount();
        }

        // add footer lines
        result += "You owe " + totalAmount + " $\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return List.of(result);
    }

}

