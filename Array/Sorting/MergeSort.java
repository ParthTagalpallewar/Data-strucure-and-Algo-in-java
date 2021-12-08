package Array.Sorting;

public class MergeSort {
    public static void main(String[] args) {
        
        int arr[] = {9, 8, 7, 5, 4, 3};
        mergeSort(arr, 0, arr.length-1);

        display(arr);

    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){

            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);

            merge(arr, left, middle, right);
            
        }
    }

    public static void merge(int arr[], int left, int middle, int right ) {
        
        int left_arr_size = middle - left + 1;
        int right_arr_size = right - middle;
        
        int left_arr[] = new int[left_arr_size];
        int right_arr[] = new int[right_arr_size];

        int i = 0, j = 0;

        for(i = 0; i < left_arr_size; i++){
            left_arr[i] = arr[left + i];
        }

        for(j = 0; j < right_arr_size; j++){
            right_arr[j] = arr[middle + 1 + j];
        }


        int k = left;
        i = 0;
        j = 0;

        while(i < left_arr_size && j < right_arr_size){

            if( left_arr[i] <= right_arr[j]){
                arr[k] = left_arr[i];
                i++;
            }
            else{
                arr[k] = right_arr[j];
                j++;
            }
            k++;
        }

        while(i < left_arr_size){
            arr[k] = left_arr[i];
            k++;
            i++;
        }

        while(j < right_arr_size){
            arr[k] = right_arr[j];
            k++;
            j++;
        }



    }

    public static void display(int arr[])
    {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
