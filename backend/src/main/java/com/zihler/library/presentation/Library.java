package com.zihler.library.presentation;

import com.zihler.library.application.BookService;
import com.zihler.library.application.IRetrieveBooks;
import com.zihler.library.domain.*;
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
        return bookService.calculateFeeFor(rentalRequests);
    }

}

