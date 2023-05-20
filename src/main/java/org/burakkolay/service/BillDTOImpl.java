package org.burakkolay.service;

import org.burakkolay.entity.Bill;
import org.burakkolay.entity.Category;
import org.burakkolay.interfaces.BillDTOInterface;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class BillDTOImpl implements BillDTOInterface {
    public List<Bill> bills = new ArrayList();

    public BillDTOImpl() {
        this.bills.add(new Bill(1, "Huawei", Category.TECHNOLOGY, 85000.0, LocalDate.of(2018, 3, 12)));
        this.bills.add(new Bill(2, "Nokia", Category.OTHER, 950.0, LocalDate.of(2013, 6, 19)));
        this.bills.add(new Bill(3, "TOGG", Category.OTHER, 150000.0, LocalDate.of(2022, 8, 6)));
        this.bills.add(new Bill(4, "Burger King", Category.FOOD, 1200.0, LocalDate.of(2021, 6, 26)));
    }

    public List<Bill> getBillList() {
        List var10000 = this.bills;
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
        return this.bills;
    }

    public List<Bill> getListByBillAmounts(int amount) {
        return (List)this.bills.stream().filter((Bill) -> {
            return Bill.getAmount() > (double)amount;
        }).collect(Collectors.toList());
    }

    public double getAverageOfBillAmounts(int amount) {
        return this.bills.stream().filter((Bill) -> {
            return Bill.getAmount() > (double)amount;
        }).mapToDouble(Bill::getAmount).average().orElse(0.0);
    }

    public Set<Category> getCategoryNamesLowerThanAverageBillAmount(int amount) {
        boolean averageFilter = this.bills.stream().filter((Bill) -> {
            return Bill.getBillingDate().getMonthValue() == Month.JUNE.getValue();
        }).mapToDouble(Bill::getAmount).average().orElse(0.0) < 750.0;
        Set<Category> categories = new LinkedHashSet();
        if (averageFilter) {
            categories = (Set)this.bills.stream().filter((Bill) -> {
                return Bill.getBillingDate().getMonthValue() == Month.JUNE.getValue();
            }).map((Bill) -> {
                return Bill.getCategory();
            }).collect(Collectors.toSet());
        }

        return (Set)categories;
    }
}
