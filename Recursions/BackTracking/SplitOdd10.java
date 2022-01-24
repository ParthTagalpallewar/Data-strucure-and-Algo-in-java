package Recursions.BackTracking;

public class SplitOdd10 {


    public static void main(String[] args) {
        
        int[] nums = {5, 5, 6, 1};
        boolean isSplitOdd10 = splitOdd10(0, nums, ArraySum(nums), 0);
        System.out.println(isSplitOdd10);
    }

    public static int ArraySum(int[] nums){

        int sum = 0;
        for(int i: nums){
            sum += i;
        }

        return sum;
        
    }

    public static boolean splitOdd10(int start, int[] nums, int total_sum, int curr_sum){
        //if one side array sum is multiple of 10 and remaining array sum is odd
        if(curr_sum % 10 == 0 && (total_sum - curr_sum) % 2 == 1){
            return true;
        }

        if(start >= nums.length) return false;

        if(splitOdd10(start+1, nums, total_sum, curr_sum+nums[start])){
            return true;
        }

        return splitOdd10(start+1, nums, total_sum, curr_sum);
    }



}
