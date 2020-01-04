package Part1Collection;

import java.util.*;

public class Part1 {
    public static void main(String[] args) {
        //Cau 1
        String inputN;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter N: ");
        inputN = scanner.nextLine();
        System.out.println("Your enter is: " + inputN);
        try {
            int numberN = Integer.parseInt(inputN);
            int result = 0;
            for(int i = 0; i <= numberN ;i++){
                result += i;
            }
            System.out.println("Result cau 1: " + result);
        } catch (Exception e){
            System.out.println("N is not number");
        }

        //cau 2
        List<Integer> input = new ArrayList<>();
        for(int i = 0; i <= 50; i++){
            input.add((int) (Math.floor(Math.random() * 100) + 1));
        }
        System.out.println("Cau 2");
        System.out.println("Input: ");
        System.out.println(input);
        List<Integer> result = sortList(input);
        System.out.println("Out put: ");
        System.out.println(result);

        //Cau3

        List<Bill> list = Bill.getList();
        System.out.println("Cau 3");
        System.out.println("Input");;
        List<Bill> newList = sortListByMoney(list);
        System.out.println("Output");
        showList(newList);

        //Cau4
        List<Bill> listC4 = Bill.getList();
        System.out.println("Cau 4");
        System.out.println("Input");
        System.out.println(listC4);
        List<String> dateList = new ArrayList<>();
        for (Bill bill : listC4) {
            dateList.add(bill.getDate());
        }
        Set<String> setWithoutDuplicateElements = new TreeSet<>(dateList);
        System.out.println("Out put");
        for (String element: setWithoutDuplicateElements) {
            System.out.println(element);
        }

        //Cau5
        System.out.println("Cau 5");
        List<Bill> listC5 = Bill.getList();
        List<Bill> listBillMoreThan1000000 = getListHaveMoneyMoreThan1000000(listC5);
        System.out.println("Output More Than 1000000: ");
        showList(listBillMoreThan1000000);

        //Cau6 cau7
        System.out.println("Cau 6 va 7");
        List<Bill> listc6c7 = Bill.getList();
        HashMap<String, List<Bill>> listBillHashMap = getBillDistinctByDate(listc6c7);
        //ket qua cau 6
        Set<Map.Entry<String, List<Bill>>> setHashMap = listBillHashMap.entrySet();
        System.out.println("Day la key and value HashMap");
        for (Map.Entry<String, List<Bill>> element: setHashMap) {
            System.out.println(element);
        }
        System.out.println(setHashMap);

        //cau 7
        List<List<Bill>> listListBill = new ArrayList<>(listBillHashMap.values());
        System.out.println("Day la List<List<Bill>>");
        for (List<Bill> element : listListBill) {
            System.out.println(element);
        }

        //cau 8
        System.out.println("Cau 8");
        Set<Bill> billSet = new HashSet<>(Bill.getList());
        for (Bill e: billSet) {
            System.out.println(e);
        }
    }
    public static List<String> getListByDate(List<Bill> bills){
        List<String> dateList = new ArrayList<>();
        for (Bill bill : bills) {
            dateList.add(bill.getDate());
        }
        return dateList;
    }
    public static HashMap<String, List<Bill>> getBillDistinctByDate(List<Bill> bills){
        HashMap<String, List<Bill>> listBillHashMap = new HashMap<>();
        List<String> dateList2 = getListByDate(bills);
        Set<String> setWithoutDuplicateElements2 = new TreeSet<>(dateList2);
        List<String> listWithoutDuplicateElements2 = new ArrayList<>(setWithoutDuplicateElements2);
        for (String element : listWithoutDuplicateElements2) {
            listBillHashMap.put(element, new ArrayList<Bill>());
        }
        for(int i = 0; i< bills.size();i++ ){
            for(int j = 0; j < listBillHashMap.size();j+=8){
                if (listBillHashMap.containsKey(bills.get(i).getDate())) {
                    listBillHashMap.get(bills.get(i).getDate()).add(bills.get(i));
                }
            }
        }
        return listBillHashMap;
    }
    public static List<Bill> sortListByMoney(List<Bill> listBill){
        listBill.sort(Comparator.comparingLong(Bill::getMoney));
        return listBill;
    }
    public static void showList(List<Bill> listBill){
        for (Bill bill : listBill) {
            System.out.println(bill.toString() + " , ");
        }
    }
    public static List<Bill> getListHaveMoneyMoreThan1000000(List<Bill> bills){
        List<Bill> result = new ArrayList<>();
        for(Bill bill: bills){
            if(bill.getMoney() > 1000000){
                result.add(bill);
            }
        }
        return result;
    }
    public static List<Integer> sortList(List<Integer> a){
        a.sort(Integer::compareTo);
        return a;
    }

}
