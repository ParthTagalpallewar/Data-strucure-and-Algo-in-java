package Array.Questions.SlindingWindows;

import java.util.*;

public class MaxKSubArrays {
    

    public static void main(String[] args) {
        
        int[] arr = {3};
        int k = 1;

        
        ArrayList<Integer> nums = maxofk(arr, k);
        System.out.println(nums);
    }

    public static ArrayList<Integer> maxofk(int[] arr, int k){
        
        int arr_len = arr.length;

        ArrayList<Integer> nums = new ArrayList<Integer>();
        Deque<Integer> deque = new LinkedList<Integer>();

        //find max of k elements
        int i = 0;
        for(; i < k; ++i){ 
            while(!deque.isEmpty() && arr[deque.getLast()] <= arr[i]){
                deque.removeLast();
            }

            deque.addLast(i);
        }

        if(arr.length == 1){
            nums.add(arr[deque.peek()]);
        }

        while (i < arr_len){

            //add biggest element in deque
            nums.add(arr[deque.element()]);

            //remove all elements which are not in deque
            while(!deque.isEmpty() && deque.peek() <= i-k){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && arr[deque.getLast()] <= arr[i]){
                deque.removeLast();
            }

            deque.addLast(i);

            i += 1;

        }

        return nums;

    }
 
}
