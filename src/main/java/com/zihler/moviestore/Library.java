package com.zihler.moviestore;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/library")
public class Library {

    @GetMapping("/books")
    public List<String[]> getBooks() throws IOException {
        final InputStream movieStream = Library.class.getResourceAsStream("/movies.csv");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(movieStream));
        final List<String[]> movies = new ArrayList<>();
        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            final String[] movie = line.split(";");
            movies.add(movie);

        }
        return movies;
    }

    @PostMapping("/fee")
    public List<String> calculateFee(@RequestBody List<String> rentalRequests) throws IOException {
        String customerName = rentalRequests.remove(0);

        final InputStream movieStream = Library.class.getResourceAsStream("/movies.csv");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(movieStream));
        final List<String[]> movies = new ArrayList<>();
        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            final String[] movie = line.split(";");
            movies.add(movie);

        }

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + customerName + "\n";

        for (int i = 0; i < rentalRequests.size(); i++) {
            final String[] rental = rentalRequests.get(i).split(" ");
            final String[] movie = movies.get(Integer.parseInt(rental[0]));
            double thisAmount = 0;

            int daysRented = Integer.parseInt(rental[1]);
            //determine amounts for rental
            switch (movie[2]) {
                case "REGULAR":
                    thisAmount += 2;
                    if (daysRented > 2)
                        thisAmount += (daysRented - 2) * 1.5;
                    break;
                case "NEW_RELEASE":
                    thisAmount += daysRented * 3;
                    break;
                case "CHILDRENS":
                    thisAmount += 1.5;
                    if (daysRented > 3)
                        thisAmount += (daysRented - 3) * 1.5;
                    break;
            }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (movie[2].equals("NEW_RELEASE") && daysRented > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental
            result += "\t" + movie[1] + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "You owed " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return List.of(result);
    }
}

