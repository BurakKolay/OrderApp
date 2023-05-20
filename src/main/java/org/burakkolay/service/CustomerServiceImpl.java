package org.burakkolay.service;

import org.burakkolay.entity.Customer;
import org.burakkolay.interfaces.CustomerDTOInterface;
import org.burakkolay.interfaces.CustomerInterface;

import java.util.List;

public class CustomerServiceImpl implements CustomerInterface {
    CustomerDTOInterface customerDTOInterface;

    public CustomerServiceImpl(CustomerDTOInterface customerDTOInterface) {
        this.customerDTOInterface = customerDTOInterface;
    }

    public void add(Customer customer) {
        this.customerDTOInterface.add(customer);
    }

    public List<Customer> getCustomerList() {
        return this.customerDTOInterface.getCustomerList();
    }

    public List<Customer> getCustomerListWithC() {
        return this.customerDTOInterface.getCustomerListWithC();
    }

    public List<String> getNameOverBills(int amount) {
        return this.customerDTOInterface.getNameOverBills(amount);
    }

    public double getCustomerInJuneTotalAmountList() {
        return this.customerDTOInterface.getCustomerInJuneTotalAmountList();
    }
}
