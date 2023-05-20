package org.burakkolay.interfaces;

import org.burakkolay.entity.Bill;
import org.burakkolay.entity.Category;

import java.util.List;
import java.util.Set;

public interface BillDTOInterface {

    List<Bill> getBillList();

    List<Bill> getListByBillAmounts(int var1);

    double getAverageOfBillAmounts(int var1);

    Set<Category> getCategoryNamesLowerThanAverageBillAmount(int var1);
}
