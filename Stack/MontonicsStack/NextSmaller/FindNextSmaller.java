package Stack.MontonicsStack.NextSmaller;
import java.util.*;
class FindNextSmaller{

    public static void main(String[] args) {
        
        int[] arr = {4, 8, 5, 2, 25};

        FindNextSmaller fns = new FindNextSmaller();
        int[] result = fns.findNextSmaller(arr);

        
        for(int i = 0; i < arr.length; i++){

            System.out.println(arr[i] + " -> " + result[i]);

        }
        
        

    }

    public int[] findNextSmaller(int[] arr){
        
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < arr.length; i++){

            while(!stack.isEmpty() && stack.peek() > arr[i]){
                Integer poppedValue = stack.pop();
                map.put(poppedValue, arr[i]);
            }

            stack.push(arr[i]);
        }

        while(!stack.isEmpty()){
            Integer popped = stack.pop();
            map.put(popped, -1);
        }

        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            result[i] = map.get(arr[i]);
        }

        return result;
    }

}