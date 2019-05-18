package com.zihler.library;

import java.util.List;

class RentalRecord {
    private final List<Rental> rentals;
    private final Customer customer;

    RentalRecord(Customer customer, List<Rental> rentals) {
        this.customer = customer;
        this.rentals = rentals;
    }

    double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }

    int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    String getCustomerName() {
        return customer.getName();
    }

    List<Rental> getRentals() {
        return rentals;
    }
}
