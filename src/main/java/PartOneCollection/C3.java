package PartOneCollection;
import java.util.List;

public class C3 {
    public static void main(String[] args) {
        List<Bill> list = Bill.getList();
        BillService sortList = new BillService();
        list = sortList.sortList(list);
        sortList.showList(list);
    }
}



