package Array.SlidingWindow;

// You are given a array, find a subArray with length 3 whose sum is maximum 

public class A001 {
    
    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 3, 4, 2};
        int sum = solution(arr);

        System.out.println(sum);
    }

    public static int solution(int[] arr){
        int l = 0;
        int r = 2;

        int sum = arr[0] + arr[1] + arr[2];
        int max = sum;

        while(r < arr.length-1){
            sum = sum-arr[l] + arr[r+1];
            System.out.println(sum);
            max = Math.max(sum, max);

            l += 1;
            r += 1;
        }

        return max;
    }

}
