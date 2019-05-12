package com.zihler.library;

import com.zihler.library.domain.Book;
import com.zihler.library.domain.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController
@RequestMapping("api/library")
public class Library {

    ResourceLoader resourceLoader;

    @Autowired
    public Library(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;

    }

    @GetMapping(value = "/books", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<String[]> getBooks() throws IOException {
        final List<String[]> books = new ArrayList<>();
        final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        resourceLoader.getResource("classpath:books.csv").getInputStream()
                )
        );
        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            final String[] book = line.split(";");
            books.add(book);
        }
        return books;
    }

    @PostMapping("/fee")
    public List<String> calculateFee(@RequestBody List<String> rentalRequests) throws IOException {
        String customerName = rentalRequests.remove(0);

        final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        resourceLoader.getResource("classpath:books.csv")
                                .getInputStream()
                )
        );

        final List<Book> books = new ArrayList<>();

        while (bufferedReader.ready()) {
            books.add(Book.from(bufferedReader.readLine()));
        }

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + customerName + "\n";

        for (int i = 0; i < rentalRequests.size(); i++) {
            String nextRequest = rentalRequests.get(i);
            final String[] rentalData = nextRequest.split(" ");
            final Book book = books.get(Integer.parseInt(rentalData[0]));
            int daysRented = Integer.parseInt(rentalData[1]);
            Rental rental = new Rental(book, daysRented);
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

