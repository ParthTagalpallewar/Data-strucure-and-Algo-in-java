package Array.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        
        int[] arr = {10, 20, 30, 40, 5};

        quickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));


    }

    public static void quickSort(int[] arr, int low, int high){
    
        if(low < high){
            int pivot = findPivot(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
       
    }

    private static int findPivot(int[] arr, int low, int high) {
        
        int pivot = arr[high];
        int i = low-1;

        for(int j = low; j < high-1; j++){

            if(arr[j] < pivot){
                i += 1;
                swap(arr, i, j);
                
            }

        }

        swap(arr, i+1, high);

        return i+1;


    }

    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
