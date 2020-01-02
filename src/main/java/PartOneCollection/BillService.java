package PartOneCollection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BillService {
    public List<Bill> sortList(List<Bill> listBill){
        listBill.sort(Comparator.comparingLong(Bill::getMoney));
        return listBill;
    }
    public void showList(List<Bill> listBill){
        for (Bill bill : listBill) {
            System.out.println(bill.toString() + " , ");
        }
    }
    public List<Bill> getListHaveMoneyMoreThan1000000(List<Bill> bills){
        List<Bill> result = new ArrayList<>();
        for(Bill bill: bills){
            if(bill.getMoney() > 1000000){
                result.add(bill);
            }
        }
        return result;
    }
}
