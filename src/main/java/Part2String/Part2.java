package Part2String;

import java.util.*;

public class Part2 {
    public static void main(String[] args){
        //Cau 1
        String s = "xin chiao the gioi xin the the moi";
        char k = 'i';
        int n = s.length();
        String search = "the";

        int countFirstChar = getCountFirstChar(s,k);
        System.out.println("Count  char k first: " + countFirstChar);

        int countLastChar = getCountLastChar(s,k);
        System.out.println("Count char k last: " + countLastChar);

        int countInPositionN = getCountInPositionN(s,k,n);
        System.out.println("Count char k in N: " + countInPositionN);

        int countFirstString = getCountStringFirst(s,search);
        System.out.println("Count string search first: " + countFirstString);

        int countLastString = getCountStringLast(s,search);
        System.out.println("Count string search last: " + countLastString);

        int countStringPositionN = getCountStringPositionN(s,search,n);
        System.out.println("Count string search N: " + countStringPositionN);

        //Cau2
        String s1 = "adbcdsdaad";
        char[] arrStr = s1.toCharArray();
        char k1 = arrStr[findId(s1)];
        List<String> arr = new ArrayList<>();
        System.out.println("Ky tu xuat hien nhieu nhat la : " + k1);
        for (int i = s1.length(); i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                arr.add(s1.substring(j,i));
            }
        }
        Set<String> stringTreeSet = new TreeSet<>(arr);
        List<String> stringArrayList = new ArrayList<>(stringTreeSet);
        stringArrayList.remove(0);
        System.out.println("Cac chuoi con: ");
        System.out.println(stringArrayList);
        List<Integer> countList = countStringList(stringArrayList,s1);
        HashMap<String,Integer> stringIntegerHashMap = new HashMap<>();
        for(int i = 0; i< stringArrayList.size();i++){
            stringIntegerHashMap.put(stringArrayList.get(i),countList.get(i));
        }
        System.out.println("Dem so lan xuat hien cua chung: ");
        System.out.println(stringIntegerHashMap);

        //cau3
        System.out.println("Cau 3");
        StringBuilder sb = new StringBuilder();
        List<String> listC3 = new ArrayList<>();
        listC3.add("ass");
        listC3.add("ass");
        listC3.add("asass");
        listC3.add("s1");
        listC3.add("s1");
        System.out.println("input:");
        System.out.println(listC3);
        for (String value : listC3) {
            sb.append(value).append(",");

        }
        String outputC3 = sb.substring(0, sb.length() - 1);
        System.out.println("output:");
        System.out.println(outputC3);

        //cau4
        System.out.println("cau4");
        System.out.println("input");
        System.out.println(outputC3);
        String[] arrC4 = outputC3.split(",");
        List<String> listC4 = new ArrayList<>();
        listC4.addAll(Arrays.asList(arrC4));
        System.out.println("output");
        System.out.println(listC4);


        //cau5
        System.out.println("cau5");
        String raw = "i am a student am";
        String from = "am";
        String to = "is";
        String result = replaceString(raw,from,to);
        System.out.println(result);

    }
    public static List<Integer> countStringList(List<String> ls, String s){
        List<Integer> countList = new ArrayList<>();
        for (String l : ls) {
            countList.add(getCountString(s, l));
        }
        return countList;
    }
    private static String replaceString(String raw, String from, String to){
        return raw.replace(from, to);
    }
    private static int getCountFirstChar(String s, char k) {
        char[] s2 = s.toCharArray();
        if(s2[0] == k){
            return 1;
        } else return 0;
    }

    private static int getCountLastChar(String s, char k){
        char[] s2 = s.toCharArray();
        if(s2[s.length()-1] == k ){
            return 1;
        } else return 0;
    }

    public static int getCountInPositionN( String s, char k, int n) {
        if(n<=s.length()){
            int countInPositionN = 0;
            char[] s2 = s.toCharArray();
            for (int i = 0; i<n;i++){
                if(s2[i] == k){
                    countInPositionN++;
                }
            }
            return countInPositionN;
        }
        return 0;
    }

    private static int getCountStringFirst(String s, String search){
        if(s.startsWith(search)){
            return 1;
        } else return 0;

    }

    private static int getCountStringLast(String s, String search){
        if(s.endsWith(search)){
            return 1;
        } else return 0;
    }

    private static int getCountStringPositionN(String s, String search, int n){
        int count = 0;
        try {
            for(int i = 0; i<n-search.length()+1;i++){
                if(search.equals(s.substring(i,(i+ search.length())))){
                    count++;
                }
            }
        } catch ( Exception e){
            System.out.println("out of bout");
        }
        return count;
    }
    private static int getCountString(String s, String search){
        int count = 0;
        try {
            for(int i = 0; i<(s.length()-search.length()+1);i++){
                if(search.equals(s.substring(i,(i+ search.length())))){
                    count++;
                }
            }
        } catch ( Exception e){
            System.out.println("out of bout");
        }
        return count;
    }

    public static int findId(String s){
        List<Integer> arr = new ArrayList<>();
        char[] arrStr = s.toCharArray();
        for (char c : arrStr) {
            arr.add(getCountInPositionN(s, c, s.length()));
        }
        return findMax(arr);
    }
    public static int findMax(List<Integer> arr){
        int max = 0;
        for (int i = 0; i< arr.size()-1; i++){
            if(arr.get(i) > arr.get(i + 1)){
                max = i;
            }
        }
        return max;
    }
}
