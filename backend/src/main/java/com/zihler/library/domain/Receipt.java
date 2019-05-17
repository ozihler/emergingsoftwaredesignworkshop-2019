package com.zihler.library.domain;

public class Receipt {
    private RentalRecord rentalRecord;

    private Receipt(RentalRecord rentalRecord) {
        this.rentalRecord = rentalRecord;
    }

    public static Receipt createFor(RentalRecord rentalRecord) {
        return new Receipt(rentalRecord);
    }

    @Override
    public String toString() {
        String result = appendHeader();
        result += appendRentals();
        result += appendFooter();
        return result;
    }

    private String appendFrequentRenterPoints() {
        return String.format("You earned %d frequent renter points\n", this.rentalRecord.getFrequentRenterPoints());
    }

    private String appendTotalAmount() {
        return String.format("You owe %s $\n", this.rentalRecord.getTotalAmount());
    }

    private String appendFooter() {
        String result = appendTotalAmount();
        result += appendFrequentRenterPoints();
        return result;
    }

    private String appendHeader() {
        return String.format("Rental Record for %s\n", this.rentalRecord.getCustomerName());
    }

    private String appendRentals() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : this.rentalRecord.getRentals()) {
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
