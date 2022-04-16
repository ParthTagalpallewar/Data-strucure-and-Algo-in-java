/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int[] nums = new int[n];
            int itr = 0;

            // for getting elements of array
            while (n-- > 0) {

                nums[itr] = sc.nextInt();
                itr += 1;

            }

            int pairs = findPairs(nums);

            System.out.println(pairs);

        }

    }

    private static int findPairs(int[] arr) {

        HashMap<Integer, Integer> map = getMap(arr);

        int pairs = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getKey() == 1)
                pairs += one_pairs(arr, map.get(1));

            else
                pairs += ((entry.getValue() * (entry.getValue() - 1)) / 2);
        }

        return pairs;

    }

    private static int one_pairs(int arr[], int one_count) {
        int pairs = 0;

        int n = arr.length - 1;
        while (n >= arr.length - one_count) {
            pairs += n;
            n -= 1;
        }

        return pairs;
    }

    private static HashMap<Integer, Integer> getMap(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {

            int num = arr[i];

            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);

            else
                map.put(num, 1);

        }

        return map;

    }

}
