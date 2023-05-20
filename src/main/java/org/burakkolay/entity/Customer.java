package org.burakkolay.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Customer {
    private String userName;
    private LocalDate registrationDate;
    private List<Bill> bills;

    public Customer(String userName, LocalDate registrationDate, List<Bill> bills) {
        this.userName = userName;
        this.registrationDate = registrationDate;
        this.bills = bills;
    }
}
