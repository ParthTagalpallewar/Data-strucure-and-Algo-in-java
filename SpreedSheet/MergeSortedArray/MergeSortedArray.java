package MergeSortedArray;
import java.util.Arrays;

public class MergeSortedArray {
    
    public static void main(String[] args) {
        
        int[] arr1 = {1, 3, 5, 7, 9, 22, 33, 44, 55, 66, 777, 888 };
        int[] arr2 = {0, 2, 6, 8, 9};

        merge(arr1, arr2, arr1.length, arr2.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }

    public static void merge(int[] arr1, int[] arr2, int n, int m) {

        int arr1_pt = 0;
        int arr2_pt = 0;

        while (arr1_pt < n && arr2_pt < m) {

            if (arr1[arr1_pt] <= arr2[arr2_pt]) {
                arr1_pt += 1;
            }

            else if (arr1[arr1_pt] > arr2[arr2_pt]) {
                int arr2_current = arr2[arr2_pt];
                addElement(arr2_pt, arr1[arr1_pt], arr2);
                arr1[arr1_pt] = arr2_current;
                arr1_pt += 1;
            }

        }

    }

    public static void addElement(int at_position, int element, int[] arr) {
        int front_element = at_position + 1;

        while (front_element < arr.length && element > arr[front_element]) {
            swap(at_position, front_element, arr);
            at_position += 1;
            front_element += 1;
        }

        arr[at_position] = element;
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
