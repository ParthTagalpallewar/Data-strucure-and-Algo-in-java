package Recursions.BackTracking;

public class GroupSum {
    public static void main(String[] args) {
        int[] nums = {2, 4, 8};
        int target = 10;
        int start = 0;


        

        boolean isSumExist = groupSum(start, nums, target);
        System.out.println(isSumExist);
    }

    public static boolean groupSum(int start, int[] nums, int target){
        if(target == 0) return true;

        if(start >= nums.length) return false;

        if(groupSum(start + 1, nums, target - nums[start]) == true){
            return true;
        }

        return groupSum(start+1, nums, target);
    }
}
