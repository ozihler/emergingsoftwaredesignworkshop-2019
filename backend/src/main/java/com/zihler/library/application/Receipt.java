package com.zihler.library.application;

import com.zihler.library.domain.Rental;
import com.zihler.library.domain.RentalRecord;

public class Receipt {
    private RentalRecord rentalRecord;

    private Receipt(RentalRecord rentalRecord) {
        this.rentalRecord = rentalRecord;
    }

    public static Receipt createFor(RentalRecord rentalRecord) {
        return new Receipt(rentalRecord);
    }

    public String formatForDisplay() {
        String result = appendHeader();
        result += appendRentals();
        result += appendFooter();
        return result;
    }

    private String appendFrequentRenterPoints() {
        return String.format("You earned %d frequent renter points\n", getRentalRecord().getFrequentRenterPoints());
    }

    private String appendTotalAmount() {
        return String.format("You owe %s $\n", getRentalRecord().getTotalAmount());
    }

    private String appendFooter() {
        String result = appendTotalAmount();
        result += appendFrequentRenterPoints();
        return result;
    }

    private RentalRecord getRentalRecord() {
        return this.rentalRecord;
    }

    private String appendHeader() {
        return String.format("Rental Record for %s\n", getRentalRecord().getCustomerName());
    }

    private String appendRentals() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : getRentalRecord().getRentals()) {
             result.append(format(rental));
        }
        return result.toString();
    }

    private String format(Rental rental) {
        return "\t'" + rental.getBookName()
                + "' by '" + rental.getBookAuthors()
                + "' for " + rental.getDaysRented()
                + " days: \t"
                + rental.getAmount()
                + " $\n";
    }
}
