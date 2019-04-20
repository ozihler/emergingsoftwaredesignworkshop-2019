package com.zihler.library;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/library")
public class Library {

    @GetMapping(value = "/books", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<String[]> getBooks() throws IOException, URISyntaxException {
        final List<String[]> books = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(Library.class.getResource("/books.csv").toURI()));
        for (String line : lines) {
            final String[] book = line.split(";");
            books.add(book);
        }
        return books;
    }

    @PostMapping("/fee")
    public List<String> calculateFee(@RequestBody List<String> rentalRequests) throws IOException {
        String customerName = rentalRequests.remove(0);

        final InputStream bookStream = Library.class.getResourceAsStream("/books.csv");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bookStream));
        final List<String[]> books = new ArrayList<>();
        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            final String[] book = line.split(";");
            books.add(book);
        }

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + customerName + "\n";

        for (int i = 0; i < rentalRequests.size(); i++) {
            final String[] rental = rentalRequests.get(i).split(" ");
            final String[] book = books.get(Integer.parseInt(rental[0]));
            double thisAmount = 0;

            int daysRented = Integer.parseInt(rental[1]);
            switch (book[3]) {
                case "NOT_FOR_SALE":
                    thisAmount += 2;
                    if (daysRented > 2)
                        thisAmount += (daysRented - 2) * 1.5;
                    break;
                case "FOR_SALE":
                    thisAmount += daysRented * 3;
                    break;
                case "FREE":
                    thisAmount += 1.5;
                    if (daysRented > 3)
                        thisAmount += (daysRented - 3) * 1.5;
                    break;
            }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (book[2].equals("NEW_RELEASE") && daysRented > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental
            result += "\t'" + book[1] + "' by '" + book[2] + "' for " + daysRented + " days: \t" + thisAmount + " $\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "You owe " + totalAmount + " $\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return List.of(result);
    }
}

