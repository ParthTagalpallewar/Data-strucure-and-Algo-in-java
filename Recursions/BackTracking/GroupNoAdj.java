package Recursions.BackTracking;

public class GroupNoAdj {
    public static void main(String[] args) {
        int[] nums = {2, 5, 10, 4};
        int target = 14;

        boolean isSum = groupNoAdj(0, nums, target);
        System.out.println(isSum);
    }

    public static boolean groupNoAdj(int start, int[] nums, int target){


        if (target == 0){
            return true;
        }

        if (start >= nums.length){
            return false;
        }


        if (groupNoAdj(start + 2, nums, target - nums[start]) == true) {
            return true;
        }

        return groupNoAdj(start + 1, nums, target);
    }
}
