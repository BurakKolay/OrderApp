package org.burakkolay.interfaces;

import org.burakkolay.entity.Customer;

import java.util.List;

public interface CustomerInterface {

    void add(Customer var1);

    List<Customer> getCustomerList();

    List<Customer> getCustomerListWithC();

    List<String> getNameOverBills(int var1);

    double getCustomerInJuneTotalAmountList();
}
