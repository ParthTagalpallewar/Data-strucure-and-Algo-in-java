package Recursions.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;


public class LetterCombinationsofaPhoneNumber {
    
    private static HashMap<String, String> map = new HashMap<String, String>();
    public static void main(String[] args) {
        prepMap();
        String phoneNumber = "23";
        ArrayList<String> LetterCombinations = lettersCombinations("",phoneNumber);

        System.out.println(LetterCombinations);
    }

    public static ArrayList<String> lettersCombinations(String p, String up){

        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }

        ArrayList<String> result = new ArrayList<String>();

        char a = up.charAt(0);
        String chars = map.get(a);
        
        for(int i = 0; i < chars.length(); i++){
            result.addAll(lettersCombinations(p + chars.charAt(i), up.substring(1)));
        }

        
        return result;
    }

    public static void prepMap(){
        map.put("2", "abc");
        map.put("3", "edf");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

    }


}
