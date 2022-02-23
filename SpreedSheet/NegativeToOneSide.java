import java.util.Arrays;

public class NegativeToOneSide {
    public static void main(String[] args) {
        int[] arr = {5, -1, -2, 7, 1, -10, 5, 7 -3};

        
    
        int left = 0;
        int right = arr.length-1;

        while(left < right){
            if(arr[left] > 0){
                swap(arr, left, right); 
                right -= 1;
            }else{
                left += 1;
            }
        }

        System.out.println(Arrays.toString(arr));
    }   

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}
