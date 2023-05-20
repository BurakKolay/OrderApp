package org.burakkolay.service;

import org.burakkolay.entity.Bill;
import org.burakkolay.entity.Category;
import org.burakkolay.interfaces.BillDTOInterface;
import org.burakkolay.interfaces.BillInterface;

import java.util.List;
import java.util.Set;

public class BillServiceImpl implements BillInterface {
    BillDTOInterface billDTOInterface;

    public BillServiceImpl(BillDTOInterface billDTOInterface) {
        this.billDTOInterface = billDTOInterface;
    }

    public List<Bill> getBillList() {
        return this.billDTOInterface.getBillList();
    }

    public List<Bill> getListByBillAmount(int amount) {
        return this.billDTOInterface.getListByBillAmounts(amount);
    }

    public double getAverageOfBillAmount(int amount) {
        return this.billDTOInterface.getAverageOfBillAmounts(amount);
    }

    public Set<Category> getCategoryNamesLowerThanAverageBillAmount(int amount) {
        return this.billDTOInterface.getCategoryNamesLowerThanAverageBillAmount(amount);
    }
}
