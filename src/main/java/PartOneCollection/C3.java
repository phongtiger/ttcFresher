package PartOneCollection;

import java.util.Comparator;
import java.util.List;

public class C3 {
    public static void main(String[] args) {
        List<Bill> list = Bill.getList();
        Sort sortList = new Sort();
        list = sortList.sortList(list);
        sortList.showList(list);
    }
}
class Sort {
    public List<Bill> sortList(List<Bill> listBill){
        listBill.sort(Comparator.comparingLong(Bill::getMoney));
        return listBill;
    }
    public void showList(List<Bill> listBill){
        for (Bill bill : listBill) {
            System.out.println(bill.toString() + " , ");
        }
    }
}



