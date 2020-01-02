package PartOneCollection;

import java.util.ArrayList;
import java.util.List;

public class C5 {
    public static void main(String[] args){
        List<Bill> list = Bill.getList();
        BillService billService = new BillService();
        List<Bill> listBillMoreThan1000000 = billService.getListHaveMoneyMoreThan1000000(list);
        billService.showList(listBillMoreThan1000000);
    }
}
