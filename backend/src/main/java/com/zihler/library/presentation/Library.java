package com.zihler.library.presentation;

import com.zihler.library.application.BookService;
import com.zihler.library.application.RentalOrder;
import com.zihler.library.application.RentalRequests;
import com.zihler.library.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController
@RequestMapping("api/library")
public class Library {
    private final BookService bookService;

    @Autowired
    public Library(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<String[]> getBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/fee")
    public List<String> calculateFee(@RequestBody List<String> rentalRequests) {
        if (rentalRequests.size() == 0) {
            throw new RuntimeException("Invalid input");
        }
        Customer customerName = new Customer(rentalRequests.remove(0));
        if (rentalRequests.size() == 0) {
            throw new RuntimeException("Missing rental requests");
        }

        RentalRequests requests = new RentalRequests(rentalRequests);

        RentalOrder rentalOrder = new RentalOrder(customerName, requests);

        return bookService.calculateFeeFor(rentalOrder);
    }

}

