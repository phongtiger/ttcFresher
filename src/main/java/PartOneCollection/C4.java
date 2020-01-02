package PartOneCollection;

import java.util.ArrayList;
import java.util.List;

public class C4 {
    public static void main(String[] args){
        List<Bill> list = Bill.getList();
        List<String> dateList = new ArrayList<>();
        for (Bill bill : list) {
            dateList.add(bill.getDate());
        }
        List<String> listWithoutDuplicateElements = new ArrayList<String>();
        for (String element : dateList) {
            if (!listWithoutDuplicateElements.contains(element)) {
                listWithoutDuplicateElements.add(element);
            }
        }
        for (String element: listWithoutDuplicateElements){
            System.out.println(element);
        }
    }
}
