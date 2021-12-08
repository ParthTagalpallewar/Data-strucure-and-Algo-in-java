package Array.Searching;

public class BinarySearch {
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 5, 6};
        int num = 6;

        int index = binarySearch(arr, 0, arr.length-1, num);
        System.out.println("Index is "+ index);

    }

    public static int binarySearch(int[] arr, int left, int right, int x){

        if(left > right){
            return -1;
        }
        
        int mid_index = left + (right - left) / 2;

        if(arr[mid_index] > x){
            return binarySearch(arr, left, mid_index-1, x);
        }else if(arr[mid_index] < x){
            return binarySearch(arr, mid_index+1, right, x);
        }else{
            return mid_index;
        }

    }

    
}
