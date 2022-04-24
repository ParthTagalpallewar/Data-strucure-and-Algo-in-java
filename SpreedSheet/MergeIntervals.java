import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        
        int[][] MergeIntervals = merge(intervals);

        for(int i = 0; i < MergeIntervals.length; i++){
            System.out.println(Arrays.toString(MergeIntervals[i]));
        }
    }

   
    public static int[][] merge(int[][] intervals) {
        quickSort(intervals, 0, intervals.length-1);

        if (intervals.length < 2)
            return intervals;

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
      
        int curr_idx = 0;
        int n = intervals.length;
        
        int smallest = Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;

        while(curr_idx < n){
            int[] curr = intervals[curr_idx];
            smallest = Math.min(smallest, curr[0]);
            biggest = Math.max(biggest, curr[1]);

           

            while(curr_idx+1 < n && intervals[curr_idx+1][0] <= biggest){

                curr_idx += 1;
                curr = intervals[curr_idx];

                smallest = Math.min(smallest, curr[0]);
                biggest = Math.max(biggest, curr[1]);

               
            }

            
            ArrayList<Integer> innerList = new ArrayList<Integer>();
            innerList.add(smallest);
            innerList.add(biggest);

            if((list.size() == 0) || (list.get(list.size()-1).get(1) != biggest) ){
                list.add(innerList);
                smallest = Integer.MAX_VALUE;
                biggest = Integer.MIN_VALUE;
            }



            curr_idx += 1;
        }
        

        return convert(list);

    }

    private static void quickSort(int[][] arr, int low, int high){
        if(low < high){

            int pivot = findPivot(arr, low, high);

            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);

        }
    }

    private static int findPivot(int[][] arr, int low, int high) {
        int[] pivot = arr[high];
        int i = low-1;

        for(int j = low; j < high; j++){
            if(arr[j][0] < pivot[0]){
                i += 1;
                swap(arr, i, j);
            }

            if(arr[j][0] == pivot[0] && arr[j][1] > pivot[1]){
                i += 1;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, high);
        return i+1;
    }

    private static void swap(int[][] arr, int a, int b){
        int[] temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int[][] convert(ArrayList<ArrayList<Integer>> list){
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> temp = list.get(i);

            int[] inner = new int[2];
            inner[0] = temp.get(0);
            inner[1] = temp.get(1);

            result[i] = inner;
        }

        return result;
    }

}
