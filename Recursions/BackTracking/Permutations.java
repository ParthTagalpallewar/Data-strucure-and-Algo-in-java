package Recursions.BackTracking;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {

        System.out.println(LinearPermutation("", "abc")); 
    }

    public static void permutation(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {

            String first = p.substring(0, i);
            String second = p.substring(i, p.length());

            permutation(first + ch + second, up.substring(1));
        }

    }
    public static ArrayList<String> LinearPermutation(String p, String up) {

        ArrayList<String> result = new ArrayList<String>();

        if (up.isEmpty()) {
            ArrayList<String> inner = new ArrayList<String>();
            inner.add(p);
            return inner;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {

            String first = p.substring(0, i);
            String second = p.substring(i, p.length());

            
            result.addAll(LinearPermutation(first + ch + second, up.substring(1)));
        }

        return result;

    }
}
