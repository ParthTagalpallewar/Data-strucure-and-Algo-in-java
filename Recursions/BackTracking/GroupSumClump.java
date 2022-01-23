package Recursions.BackTracking;

public class GroupSumClump {
    public static void main(String[] args) {
        int[] nums = {2, 4, 8};
        int target = 10;

        boolean result = groupSumClump(0, nums, target);
        System.out.println(result);
    }

    public static boolean groupSumClump(int start, int[] nums, int target) {

        if (target == 0)
            return true;

        if (start >= nums.length)
            return false;

        int adjSum = nums[start]; 
        int endvalue = start; 

        while (endvalue+1 < nums.length && nums[endvalue+1] == nums[start]) {
            adjSum += nums[endvalue];
            endvalue += 1; 
        }

        if (groupSumClump(endvalue+1, nums, target - adjSum)) {
            return true;
        }

        return groupSumClump(endvalue+1, nums, target);

    }
}
