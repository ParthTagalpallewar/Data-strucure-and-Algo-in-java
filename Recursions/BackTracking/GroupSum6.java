package Recursions.BackTracking;

public class GroupSum6 {
    public static void main(String[] args) {
        int[] nums = {1, 6, 2, 6, 4};
        int target = 9;

        boolean isGroupSum6 = groupSum6(0, nums, target);
        System.out.println(isGroupSum6);
    }

    public static boolean groupSum6(int start, int[] nums, int target) {
        if (target == 0) {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] == 6)
                    return false;
            }
            return true;
        }

        if (start >= nums.length)
            return false;

        if (nums[start] == 6)
            return groupSum6(start + 1, nums, target - 6);

        if (groupSum6(start + 1, nums, target - nums[start])) {
            return true;
        }

        return groupSum6(start + 1, nums, target);
    }

}
