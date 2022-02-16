package Array.Questions;

import java.util.Arrays;

public class RearrangeElementsAlternative {
    
    public static void main(String[] args) {
        long[] arr = {1,2,3,4,5,6};
        rearrange(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(long[] arr, int n){
        int min_idx = 0;
        int max_idx = n-1;

        long max_ele = arr[max_idx] + 1;

        for (int i = 0; i < arr.length; i++) {
            
            if(i % 2 == 0){
                arr[i] += arr[max_idx] % max_ele * max_ele;
                max_idx -= 1;
            }else{
                arr[i] += arr[min_idx] % max_ele * max_ele;
                min_idx += 1;
            }

        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / max_ele;
        }
    }

}


