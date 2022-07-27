package priratyArray;

public class prirityArray {
    public static void main(String[] args) {
        
        int arr[] = {2, 4, 8, 1, 2, 9, 8};

        // 2, 4, 8
        // 4, 8, 1
        // 8, 1, 2
        // 1, 2, 1
        // 2, 1, 8

        int n = arr.length;
        int k = 2;

        int max = 0;
        int prev = 0;

        for(int i=0; i<k; i++) max += arr[i];

        prev = max;

        int low = 0;
        int high = k;

        while(high < n){

            int curr_sum = (prev - arr[low]) + arr[high];
            
            max = Math.max(max, curr_sum);

            prev = curr_sum;
            low += 1;
            high += 1;

        }

        System.out.println(max);

    }
}
