package Array.Questions;

import java.util.Arrays;
import java.util.HashMap;

public class MinSwapsToSort {
    public static void main(String[] args) {
        // int[] arr = {7, 16, 14, 17, 6, 9, 5, 3, 18};
        // System.out.println(minSwaps(arr));

        // int value = (9 + (7 * 12)) % 12;
        // System.out.println(value);

        System.out.println(3 % 5);
    }

    public static int minSwaps(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // store index of all elements in hashmap with key as value
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        Arrays.sort(arr);

        int count = 0;

        // check how many elements are not at there position
        for (int i = 0; i < arr.length; i++) {
            int previous_index = map.get(arr[i]);
            if (previous_index != i) {
                count += 1;
            }
        }

        return count / 2;
    }
}
