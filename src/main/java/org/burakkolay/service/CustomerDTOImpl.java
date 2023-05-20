package org.burakkolay.service;

import org.burakkolay.entity.Bill;
import org.burakkolay.entity.Customer;
import org.burakkolay.interfaces.CustomerDTOInterface;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomerDTOImpl implements CustomerDTOInterface {

    public List<Customer> customers = new ArrayList();

    public CustomerDTOImpl() {
        this.customers.add(new Customer("Ahmet", LocalDate.of(2017, 2, 12), List.of(new Bill[]{(Bill) (new BillDTOImpl()).bills.get(0)})));
        this.customers.add(new Customer("Cafer", LocalDate.of(2023, 5, 7), List.of(new Bill[]{(Bill) (new BillDTOImpl()).bills.get(1)})));
        this.customers.add(new Customer("Hamdi", LocalDate.of(2015, 9, 22), List.of(new Bill[]{(Bill) (new BillDTOImpl()).bills.get(2)})));
        this.customers.add(new Customer("Ayşe", LocalDate.of(2011, 6, 3), List.of(new Bill[]{(Bill) (new BillDTOImpl()).bills.get(3)})));
    }

    public void add(Customer customer) {
        this.customers.add(customer);
    }

    public List<Customer> getCustomerList() {
        List var10000 = this.customers;
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
        return this.customers;
    }

    public List<Customer> getCustomerListWithC() {
        return (List)this.customers.stream().filter((customer) -> {
            return customer.getUserName().startsWith("C");
        }).collect(Collectors.toList());
    }

    public List<String> getNameOverBills(int amount) {
        return (List)this.customers.stream().filter((customer) -> {
            return customer.getBills().stream().anyMatch((Bill) -> {
                return Bill.getAmount() < (double)amount;
            });
        }).map((customer) -> {
            return customer.getUserName();
        }).collect(Collectors.toList());
    }

    public double getCustomerInJuneTotalAmountList() {
        return this.customers.stream().filter((customer) -> {
            return customer.getRegistrationDate().getMonthValue() == 6;
        }).flatMap((Bill) -> {
            return Bill.getBills().stream();
        }).mapToDouble(Bill::getAmount).sum();
    }
}
