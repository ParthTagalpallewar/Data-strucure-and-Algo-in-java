public class RecursionBubbleSort {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int[] sorted = bubbleSort(nums, 1, nums.length);

        for(int i: sorted){
            System.out.print(i + " ");
        }
    }

    public static int[] bubbleSort(int[] nums, int start, int end){
        if(start >= end) return nums;

        nums = innerSort(nums, start, end);
        
        return bubbleSort(nums, start, end-1);
    }

    public static int[] innerSort(int[] nums, int start, int size){
        if(start >= size) return nums;

        if(nums[start-1] > nums[start]){
            int temp = nums[start];
            nums[start] = nums[start-1];
            nums[start-1] = temp;
        }

        return innerSort(nums, start+1, size);
    }
}
