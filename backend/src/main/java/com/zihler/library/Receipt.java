package com.zihler.library;

import static java.util.stream.Collectors.joining;

public class Receipt {
    private RentalRecord rentalRecord;

    Receipt(RentalRecord rentalRecord) {
        this.rentalRecord = rentalRecord;
    }

    @Override
    public String toString() {
        String result = formatTitle();
        result += formatRentalFigures();
        result += formatFooter();
        return result;
    }

    private String formatTitle() {
        return "Rental Record for " + rentalRecord.getCustomerName() + "\n";
    }

    private String formatRentalFigures() {
        return rentalRecord.getRentals()
                .stream()
                .map(this::format)
                .collect(joining());
    }

    private String format(Rental rental) {
        // create figures for this rental
        return String.format("\t'%s' by '%s' for %d days: \t%s $\n", rental.getBook().getTitle(), rental.getBook().getAuthors(), rental.getDaysRented(), rental.getAmount());
    }

    private String formatFooter() {
        String result = "";
        result += formatTotalAmount();
        result += formatFrequentRenterPoints();
        return result;
    }

    private String formatTotalAmount() {
        return "You owe " + rentalRecord.getTotalAmount() + " $\n";
    }

    private String formatFrequentRenterPoints() {
        return "You earned " + rentalRecord.getFrequentRenterPoints() + " frequent renter points\n";
    }
}
