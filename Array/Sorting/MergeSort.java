package Array.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left >= right) return;

        int middle = left + (right-left) /2;

        mergeSort(arr, left, middle);
        mergeSort(arr, middle+1, right);

        merge(arr, left, middle, right);

    }

    public static void merge(int[] arr, int left, int middle, int right){
 
        int left_n = middle-left+1;
        int right_n = right-middle;

        int[] left_arr = new int[left_n];
        int[] right_arr = new int[right_n];

        for(int i=0; i<left_n; i++) left_arr[i] = arr[left+i];
        for(int i=0; i<right_n; i++) right_arr[i] = arr[middle+1+i];

        int k = left;
        int i = 0;
        int j = 0;

        while(i < left_n && j < right_n){

            if(left_arr[i] > right_arr[j]){
                arr[k] = left_arr[i];
                i += 1;
            }else{
                arr[k] = right_arr[j];
                j += 1;
            }

            k += 1;

        }

        while(i < left_n){
            arr[k] = left_arr[i];
            i+=1;
            k+=1;
        }

        while(j < right_n){
            arr[k] = right_arr[j];
            j+=1;
            k+=1;
        }
    }
}
