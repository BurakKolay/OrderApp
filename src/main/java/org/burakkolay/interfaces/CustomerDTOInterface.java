package org.burakkolay.interfaces;

import org.burakkolay.entity.Customer;

import java.util.List;

public interface CustomerDTOInterface {

    void add(Customer var1);

    List<Customer> getCustomerList();

    List<Customer> getCustomerListWithC();

    List<String> getNameOverBills(int var1);

    double getCustomerInJuneTotalAmountList();
}
