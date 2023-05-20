package org.burakkolay;

import org.burakkolay.entity.Bill;
import org.burakkolay.entity.Customer;
import org.burakkolay.interfaces.BillInterface;
import org.burakkolay.interfaces.CustomerInterface;
import org.burakkolay.service.BillDTOImpl;
import org.burakkolay.service.BillServiceImpl;
import org.burakkolay.service.CustomerDTOImpl;
import org.burakkolay.service.CustomerServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static BillInterface billInterface = new BillServiceImpl(new BillDTOImpl());
    static CustomerInterface customerInterface = new CustomerServiceImpl(new CustomerDTOImpl());

    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Customers List:");
        customerInterface.add(new Customer("Burak", LocalDate.of(2012, 6, 13), List.of(new Bill[0])));
        customerInterface.getCustomerList();
        System.out.println(" ");
        System.out.println("Bills List: ");
        billInterface.getBillList();
        System.out.println(" ");
        System.out.println("Requests: ");
        System.out.println("List of customers with the letter 'C' in it: " + customerInterface.getCustomerListWithC());
        System.out.println("The total amount of Bills of registered customers in June: " + customerInterface.getCustomerInJuneTotalAmountList());
        System.out.println("List of Bills higher than the entered parameter value: " + billInterface.getListByBillAmount(1500));
        System.out.println("Average of Bills higher than the entered parameter value: " + billInterface.getAverageOfBillAmount(1500));
        System.out.println("Names of customers with Bills less than the entered parameter value: " + customerInterface.getNameOverBills(500));
        System.out.println("Category names whose average Bill for June is lower than the entered parameter value: " + billInterface.getCategoryNamesLowerThanAverageBillAmount(750));
    }
}