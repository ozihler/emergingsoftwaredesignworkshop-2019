package com.zihler.library.application;

import com.zihler.library.domain.Customer;

public class RentalOrder {
    private final Customer customer;
    private final RentalRequests rentalRequests;

    public RentalOrder(Customer customer, RentalRequests rentalRequests) {
        this.customer = customer;
        this.rentalRequests = rentalRequests;
    }

    Customer getCustomer() {
        return customer;
    }

    RentalRequests getRentalRequests() {
        return rentalRequests;
    }
}
