package com.zihler.library.domain;

import java.util.List;

public class RentalRecord {
    private final String customerName;
    private final List<Rental> rentals;

    public RentalRecord(String customerName, List<Rental> rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : getRentals()) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : getRentals()) {
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }
}
