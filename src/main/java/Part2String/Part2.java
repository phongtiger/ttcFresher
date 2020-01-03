package Part2String;

import java.util.*;

public class Part2 {
    public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';
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
        Set<String> setInteger = new TreeSet<>(arr);
        List<String> newSetList = new ArrayList<>(setInteger);
        newSetList.remove(0);
        System.out.println(newSetList);
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
        if(n<=s.length()){
            String newString = s.substring(0,n);
            Map<String, Integer> wordMap = countWords(newString);
            for (String key : wordMap.keySet()) {
                if(key.equals(search)){
                    count = wordMap.get(key);
                }
            }
        }
        return count;
    }

    public static void addWord(Map<String, Integer> wordMap, StringBuilder sb) {
        String word = sb.toString();
        if (word.length() == 0) {
            return;
        }
        if (wordMap.containsKey(word)) {
            int count = wordMap.get(word) + 1;
            wordMap.put(word, count);
        } else {
            wordMap.put(word, 1);
        }
    }

    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordMap = new TreeMap<String, Integer>();
        if (input == null) {
            return wordMap;
        }
        int size = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) != SPACE && input.charAt(i) != TAB
                    && input.charAt(i) != BREAK_LINE) {
                sb.append(input.charAt(i));
            } else {
                addWord(wordMap, sb);
                sb = new StringBuilder();
            }
        }
        addWord(wordMap, sb);
        return wordMap;
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
