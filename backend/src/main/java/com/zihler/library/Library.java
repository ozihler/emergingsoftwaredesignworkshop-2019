package com.zihler.library;

import com.zihler.library.dataaccess.BookRepository;
import com.zihler.library.domain.Book;
import com.zihler.library.domain.Rental;
import com.zihler.library.domain.RentalFactory;
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

        int frequentRenterPoints = getFrequentRenterPoints(rentals);
        double totalAmount = getTotalAmount(rentals);

        String result = "Rental Record for " + customerName + "\n";
        for (Rental rental : rentals) {
            // create figures for this rental
            result += "\t'" + rental.getBookName()
                    + "' by '" + rental.getBookAuthors()
                    + "' for " + rental.getDaysRented()
                    + " days: \t"
                    + rental.getAmount()
                    + " $\n";
        }


        // add footer lines
        result += "You owe " + totalAmount + " $\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";

        return List.of(result);
    }

    private double getTotalAmount(List<Rental> rentals) {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }

    private int getFrequentRenterPoints(List<Rental> rentals) {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

}

