package PartOneCollection;

import java.util.ArrayList;
import java.util.List;

class Part2 {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        for(int i = 0; i <= 50; i++){
            input.add((int) (Math.floor(Math.random() * 100) + 1));
        }
        SortList sortList = new SortList();
        List<Integer> result = sortList.sortList(input);
        System.out.println(result);
    }

}
class SortList{
    public List<Integer> sortList(List<Integer> a){
        a.sort(Integer::compareTo);
        return a;
    }
}
