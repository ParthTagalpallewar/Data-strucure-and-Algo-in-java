package Array.Questions.SlindingWindows;

import java.util.HashMap;

public class LongestKUniqueCharacter {
    public static void main(String[] args) {
        String s = "asdfj";

        int count = LongestDistintChars(s);

        System.out.println(count);

    }

    public static int LongestDistintChars(String s){

        int left = 0;
        int right = 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;

        while(right < s.length()){

            char current = s.charAt(right);

            if(map.containsKey(current)){

                left = map.get(current) + 1;
                map.clear();  

            }

            map.put(current, right);
            count = Math.max(count, right - left + 1);
            right += 1;

        }

        return count;


    }
}
