package Part1Collection;

import java.util.*;

public class Part1 {
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
        List<Bill> listc4 = Bill.getList();
        System.out.println("Cau 4");
        System.out.println("Input");
        System.out.println(listc4);
        List<String> dateList = new ArrayList<>();
        for (Bill bill : listc4) {
            dateList.add(bill.getDate());
        }
        Set<String> setWithoutDuplicateElements = new TreeSet<>(dateList);
        System.out.println("Out put");
        System.out.println(setWithoutDuplicateElements);

        //Cau5
        List<Bill> listC5 = Bill.getList();
        List<Bill> listBillMoreThan1000000 = getListHaveMoneyMoreThan1000000(listC5);
        System.out.println("output c5: ");
        showList(listBillMoreThan1000000);

        //Cau6 cau7
        List<Bill> listc6c7 = Bill.getList();
        HashMap<String, List<Bill>> listBillHashMap = new HashMap<>();
        List<String> dateList2 = new ArrayList<>();
        for (Bill bill : listc6c7) {
            dateList2.add(bill.getDate());
        }
        List<String> listWithoutDuplicateElements2 = new ArrayList<String>();
        for (String element : dateList2) {
            if (!listWithoutDuplicateElements2.contains(element)) {
                listWithoutDuplicateElements2.add(element);
            }
        }
        for (String element : listWithoutDuplicateElements2) {
            listBillHashMap.put(element, new ArrayList<Bill>());
        }
        for(int i = 0; i< listc6c7.size();i++ ){
            for(int j = 0; j < listBillHashMap.size();j+=8){
                if (listBillHashMap.containsKey(listc6c7.get(i).getDate())) {
                    listBillHashMap.get(listc6c7.get(i).getDate()).add(listc6c7.get(i));
                }
            }
        }
        //ket qua cau 6
        Set<Map.Entry<String, List<Bill>>> setHashMap = listBillHashMap.entrySet();
        System.out.println("Day la key and value HashMap");
        System.out.println(setHashMap);
        //cau 7
        List<List<Bill>> listListBill = new ArrayList<>();
        for (List<Bill> value : listBillHashMap.values()) {
            listListBill.add(value);
        }
        System.out.println("Day la List<List<Bill>>");
        System.out.println(listListBill);

    }
}
