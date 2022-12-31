import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.*;

public class Sets {
    public static void main(String[] args) {
        HashSet a = new HashSet<Integer>();
        TreeSet b = new TreeSet<Integer>();
        LinkedHashSet c = new LinkedHashSet<Integer>();

        a.add(10);

        String str = "ab45c7c8";
        int n = str.length();

        HashMap<Character, Integer> map = constructMap();

        int sum = 0;
        
        for (int index = 0; index < n; index++) {
            char curr = str.charAt(index);

            if(map.containsKey(curr)){
                sum += map.get(curr);
            }
        }
        
        System.out.println(sum);
    }

    public static HashMap<Character, Integer> constructMap(){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5',5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8',8);
        map.put('9', 9);

        return map;

    }
}
