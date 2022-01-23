package Recursions.BackTracking;

public class SplitArray {

    public static void main(String[] args) {
        SplitArray sp = new SplitArray();
        int[] nums = {2, 2, 10, 10, 1, 1};
        boolean result = sp.splitArray(nums);
    
        System.out.println(result);
    }

    public boolean splitArray(int[] nums) {

      

        int start = 0;

        int nums_len = getSum(nums);

        // check if sum of array is odd return false
        if (nums_len % 2 == 1)
            return false;

        int target = nums_len / 2;

        if (checkHalf(start, nums, target)) {
            return true;
        }

        return false;

    }

    public int getSum(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return sum;
    }

    public boolean checkHalf(int start, int[] nums, int target) {

        
        if (target == 0)
            return true;

        if (start >= nums.length)
            return false;

        if (checkHalf(start + 1, nums, target - nums[start])) {
            nums[start] = 0;
            return true;
        }

        return checkHalf(start + 1, nums, target);
    }

}