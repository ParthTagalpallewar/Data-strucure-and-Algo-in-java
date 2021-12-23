package Stack.MontonicsStack.NextGreater;

import java.util.*;

class FindNextGreater {

    public static void main(String[] args) {

        int[] arr = { 4, 8, 5, 2, 25 };

        FindNextGreater fns = new FindNextGreater();
        int[] result = fns.findNextGreater(arr);

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i] + " -> " + result[i]);

        }

    }

    public int[] findNextGreater(int[] arr) {

        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[arr.length];
       
        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                Integer poppedValue = stack.pop();
                result[poppedValue] = arr[i]; 
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer popped = stack.pop();
            result[popped] = -1;
        }

        return result;
    }

}