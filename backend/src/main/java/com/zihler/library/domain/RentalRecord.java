package com.zihler.library.domain;

public class RentalRecord {
    private final Customer customer;
    private final Rentals rentals;

    public RentalRecord(Customer customer, Rentals rentals) {
        this.customer = customer;
        this.rentals = rentals;
    }

    String getCustomerName() {
        return customer.getName();
    }

    Rentals getRentals() {
        return rentals;
    }

    int getFrequentRenterPoints() {
        return rentals.stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }

    double getTotalAmount() {
        return rentals.stream()
                .mapToDouble(Rental::getAmount)
                .sum();
    }
}
