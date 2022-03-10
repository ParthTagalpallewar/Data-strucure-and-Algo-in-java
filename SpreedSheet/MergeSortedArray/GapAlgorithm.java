package MergeSortedArray;

import java.util.*;

public class GapAlgorithm {

    public static void main(String[] args) {
        // int[] arr1 = {7, 9};
        // int[] arr2 = {1, 2};
        int[] arr1 = {1, 35};
        int[] arr2 = {6, 9, 13, 15, 20, 25, 29, 46};

System.out.println("started executions");

        merge(arr1, arr2, arr1.length, arr2.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }

    private static void merge(int[] arr1, int[] arr2, int n, int m) {

        int gap = (int) Math.floor((n + m) / 2);

        if((m+n) % 2 == 1) gap += 1;

        while (gap > 0) {

            int first = 0;
            int second = gap;

            while (second < n + m) {

                if (first < n && second < n && arr1[first] > arr1[second]) {
                    singleSwap(first, second, arr1);
                }

                if (first < n && second >= n && arr1[first] > arr2[Math.abs(second - n)]) {
                    multiSwap(first, Math.abs(second - n), arr1, arr2);
                }

                if(first > n && second > n && second < n+m && arr2[Math.abs(second-n)] > arr2[Math.abs(second-n)]){
                    singleSwap(Math.abs(second-n), Math.abs(second-n), arr2);
                }

                first += 1;
                second += 1;

            }

            int a = gap;

            gap = (int) Math.ceil(gap / 2);

            if(a != 1 && a % 2 == 1) gap += 1;
        }

    }

    public static void singleSwap(int a, int b, int[] arr) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public static void multiSwap(int a, int b, int[] arr1, int[] arr2) {

        int temp = arr1[a];
        arr1[a] = arr2[b];
        arr2[b] = temp;

    }

}
