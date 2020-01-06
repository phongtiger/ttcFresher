package ttcfresher;

import java.util.*;

public class Part2 {
    public static void main(String[] args){
        //Cau 1
        System.out.println("Cau 1");
        String s = "in chiao the gioi xin the the moi";
        System.out.println("Input: " + s);
        char k = 'i';
        int n = 6;
        int n2 = 3;

        String search = "the";
        int countCharN = getCountCharN(s,k);
        System.out.println(" Số lần xuất hiện của k là: " + countCharN);
        int positionFirstChar = s.indexOf(k)+1;
        System.out.println("Position  char k first: " + positionFirstChar);

        int positionLastChar = s.lastIndexOf(k)+1;
        System.out.println("Position char k last: " + positionLastChar);

        int positionByCountN = getPositionByCountN(s,k,n);
        System.out.println("Position char k in N : " + positionByCountN);

        int countStringSearch = getCountString(s,search);
        System.out.println("Số lần xuất hiện của \""+search+ "\" trong " + s+ " là: "+ countStringSearch);

        int positionStringFirst = s.indexOf(search)+1;
        System.out.println("Position string search first: " + positionStringFirst);

        int positionStringLast = s.lastIndexOf(search)+1;
        System.out.println("Position string search last: " + positionStringLast);

        int positionStringByCountN = getPositionStringByCountN(s,search,n2);
        System.out.println("Position string \""+ search +"\"  search N: " + positionStringByCountN);

        //Cau2
        System.out.println(" ");
        System.out.println("Cau 2");
        String s1 = "adbcda";
        System.out.println("Input: " + s1);
        System.out.println("Danh sach ky tự xuất hiện nhiều nhất là : " + findListMax(findHashMapCharacter(s1)));

        HashMap<String,Integer> stringIntegerHashMap = getChildAndCount(s1);
        System.out.println("String va so lan xuat hien: ");
        for (Map.Entry<String,Integer> element : stringIntegerHashMap.entrySet()) {
            System.out.println(element);
        }

        //cau3
        System.out.println(" ");
        System.out.println("Cau 3");
        List<String> listC3 = new ArrayList<>();
        listC3.add("ass");
        listC3.add("ass");
        listC3.add("asass");
        listC3.add("s1");
        listC3.add("s1");
        System.out.println("input:");
        System.out.println(listC3);
        String result = String.join(",",listC3);
        System.out.println("output:");
        System.out.println(result);

        //cau4
        System.out.println(" ");
        System.out.println("Cau 4");
        System.out.println("input");
        System.out.println(result);
        String[] arrC4 = result.split(",");
        List<String> listC4 = new ArrayList<>(Arrays.asList(arrC4));
        System.out.println("output");
        System.out.println(listC4);

        //cau5
        System.out.println(" ");
        System.out.println("Cau 5");
        String raw = "i am a student am";
        String from = "am";
        String to = "is";
        String result2 = replaceString(raw,from,to);
        System.out.println("raw: " +raw);
        System.out.println("from: "+from);
        System.out.println("to: "+ to);
        System.out.println(result2);

    }

    private static int getCountCharN(String s, char k) {
        int countInPositionN = 0;
        char[] s2 = s.toCharArray();
        for (int i = 0; i<s.length();i++){
            if(s2[i] == k){
                countInPositionN++;
            }
        }
        return countInPositionN;
    }

    public static HashMap<String,Integer> getChildAndCount(String s){
        HashMap<String,Integer> result = new HashMap<>();
        for (int i = s.length(); i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                if(!result.containsKey(s.substring(j,i))){
                    result.put(s.substring(j,i),1);
                } else result.replace(s.substring(j,i),result.get(s.substring(j,i))+1);
            }
        }
        result.remove("");
        return result;
    }

    private static String replaceString(String raw, String from, String to){
        return raw.replace(from, to);
    }

    public static int getPositionByCountN(String s, char k, int n) {
        int count = 0;
        int position = 0;
        char[] s2 = s.toCharArray();
        for (int i = 0; i<s.length();i++){
            if(s2[i] == k){
                count++;
                if(count == n){
                    position = i+1;
                    break;
                }
            }
        }
        return position;
    }

    private static int getPositionStringByCountN(String s, String search, int n){
        int count = 0;
        int position = 0;
        for(int i = 0; i<(s.length()-search.length()+1);i++){
            if(search.equals(s.substring(i,(i+ search.length())))){
                count++;
                if(count == n){
                    position = i+1;
                    break;
                }
            }
        }
        return position;
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

    public static HashMap<Character,Integer> findHashMapCharacter(String s){
        HashMap<Character, Integer> arr = new HashMap<>();
        char[] stringsArr = s.toCharArray();
        for (char c : stringsArr) {
            arr.put(c, getCountCharN(s, c));
        }
        return arr;
    }
    public static List<Character> findListMax(HashMap<Character, Integer> arr){
        List<Character> characterList = new ArrayList<>();
        int maxValue = Collections.max(arr.values());
        for (Map.Entry<Character,Integer> element : arr.entrySet()) {
            if(element.getValue()==maxValue){
                characterList.add(element.getKey());
            }
        }
        return characterList;
    }
}
