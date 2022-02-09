package Array.Sorting.Questions;

import java.util.Arrays;

// Java program to solve nut and bolt problem using Quick Sort
public class NutsAndBoltsMatch {
    // Driver method
    public static void main(String[] args) {
        // Nuts and bolts are represented as array of characters
        char nuts[] = { '@', '#', '$', '%', '^', '&' };
        char bolts[] = { '$', '%', '&', '^', '@', '#' };

        // Method based on quick sort which matches nuts and bolts
        matchPairs(nuts, bolts, 0, 5);

        System.out.println("Matched nuts and bolts are : ");
        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }

    // Method which works just like quick sort
    private static void matchPairs(char[] nuts, char[] bolts, int low,
            int high) {
        if (low < high) {
            // Choose last character of bolts array for nuts partition.
            int pivot = partition(nuts, low, high, bolts[high]);

            // Now using the partition of nuts choose that for bolts
            // partition.
            partition(bolts, low, high, nuts[pivot]);

            // Recur for [low...pivot-1] & [pivot+1...high] for nuts and
            // bolts array.
            matchPairs(nuts, bolts, low, pivot - 1);
            matchPairs(nuts, bolts, pivot + 1, high);
        }
    }

    // Similar to standard partition method. Here we pass the pivot element
    // too instead of choosing it inside the method.
    private static int partition(char[] arr, int low, int high, char pivot) {
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            } else if (arr[j] == pivot) {
                swap(arr, j, high);
                j--;
            }
        }

        swap(arr, i, high);

        // Return the partition index of an array based on the pivot
        // element of other array.
        return i;
    }

    private static void swap(char arr[], int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
