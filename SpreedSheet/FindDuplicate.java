public class FindDuplicate {
    public static void main(String[] args) {
        
        int[] nums = { 1, 3, 4, 2, 2};
        int duplicate = findDuplicate(nums);

        System.out.println("Duplicate Number is " + duplicate);
    }   

    public static int findDuplicate(int[] nums) {

        int sumOfN = (nums.length * (nums.length - 1)) / 2;

        int arr_sum = arrsum(nums);

        System.out.println("sum of arr is "+ arr_sum);

        if (arr_sum - sumOfN > 0 && arr_sum - sumOfN < nums.length) {
            return arr_sum - sumOfN;
        }

        return arr_sum / nums.length;
    }

    public static int arrsum(int[] arr) {

        int sum = 0;

        for (int a : arr)
            sum += a;

        return sum;

    }
}
