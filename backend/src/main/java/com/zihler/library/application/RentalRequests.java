package com.zihler.library.application;

import java.util.List;

public class RentalRequests {
    private List<String> rentalRequests;

    public RentalRequests(List<String> rentalRequests) {
        this.rentalRequests = rentalRequests;
    }

    List<String> getRentalRequests() {
        return rentalRequests;
    }
}
