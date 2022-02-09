package Array.Sorting.Questions;

//User function Template for Java
import java.util.*;

class SortByFreq {

    public static void main(String[] args) {
        
        
        int[] arr = {6, 6, 2, 3, 1, 4, 1, 5, 6, 2, 8, 7, 4, 2, 1, 3, 4, 5, 9, 6};
        ArrayList<Integer> result = sortByFreq(arr, arr.length);

        System.out.println(result);

    }

    // Function to sort the array according to frequency of elements.
    static ArrayList<Integer> sortByFreq(int arr[], int n) {
        HashMap<Integer, Integer> map = getFreq(arr);

        ArrayList<Holding> holdings = convertHashMap(map);

        ArrayList<Integer> array = new ArrayList<Integer>();

        QuickSort(holdings, 0, holdings.size() - 1);

        for (int i = 0; i < holdings.size(); i++) {
            int curr_freq = holdings.get(i).frequency;

            for (int j = 0; j < curr_freq; j++) {
                array.add(holdings.get(i).value);
            }
        }

        return array;
    }

    static HashMap<Integer, Integer> getFreq(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        return map;
    }

    static ArrayList<Holding> convertHashMap(HashMap<Integer, Integer> map) {

        ArrayList<Holding> holdings = new ArrayList<Holding>();

        for (Map.Entry element : map.entrySet()) {
            holdings.add(new Holding((int) element.getKey(), (int) element.getValue()));
        }

        return holdings;

    }

    static void QuickSort(ArrayList<Holding> holding, int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high)/2;

        QuickSort(holding, low, mid);
        QuickSort(holding, mid+1, high);

        mergeSort(holding, low, mid, high);

    }

    private static void mergeSort(ArrayList<Holding> nums, int low, int mid, int high) {

        ArrayList<Holding> arr1 = new ArrayList<Holding>();
        ArrayList<Holding> arr2 = new ArrayList<Holding>();

        for(int i = low; i <= mid; i++){
            arr1.add(nums.get(i));
        }

        for(int i = mid+1; i <= high; i++){
            arr2.add(nums.get(i));
        }

        int k = low;
        int arr1_idx = 0;
        int arr2_idx = 0;

        while(arr1_idx < arr1.size() && arr2_idx < arr2.size()){
           
            if(arr1.get(arr1_idx).frequency == arr2.get(arr2_idx).frequency){

                if(arr1.get(arr1_idx).value < arr2.get(arr2_idx).value){
                    nums.set(k, arr1.get(arr1_idx));
                    arr1_idx += 1;
                }else{
                    nums.set(k, arr2.get(arr2_idx));
                    arr2_idx += 1;
                }
            }
          
            else if(arr1.get(arr1_idx).frequency > arr2.get(arr2_idx).frequency){
                nums.set(k, arr1.get(arr1_idx));
                arr1_idx += 1;
            }else{
                nums.set(k, arr2.get(arr2_idx));
                arr2_idx += 1;
            }

            k += 1;


        }

        while(arr1_idx < arr1.size()){
            nums.set(k, arr1.get(arr1_idx));
            arr1_idx += 1;
            k += 1;
        }

        while(arr2_idx < arr2.size()){
            nums.set(k, arr2.get(arr2_idx));
            arr2_idx += 1;
            k += 1;
        }
    }

}


class Holding {
    int value;
    int frequency;

    public Holding(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }
}