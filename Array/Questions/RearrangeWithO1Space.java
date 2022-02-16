package Array.Questions;

import java.util.Arrays;

public class RearrangeWithO1Space {
    public static void main(String[] args) {
        long[] arr = {4,0,2,1,3};
        arrange(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    static void arrange(long arr[], int n){
            
        for (int i = 0; i < n; i++) {
            arr[i] += (arr[(int) arr[i]] % n) * n;
        }

        for (int i = 0; i < n; i++) {
            arr[i] /= n;
        }
    }
}
