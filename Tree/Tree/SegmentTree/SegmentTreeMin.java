package Tree.Tree.SegmentTree;

import java.util.Arrays;

public class SegmentTreeMin {
    int tree[];

    public SegmentTreeMin(int arr[], int n){
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));

        int max_size = 2 * (int) Math.pow(2, x) - 1;

        tree = new int[max_size];

        build_segmented_tree(0, n-1, arr, 0);
    }

    private int build_segmented_tree(int start, int end, int[] arr, int current) {
        
        if(start == end){
            tree[current] = arr[start];
            return arr[start];
        }

        int mid = (start + end) / 2;

        int left = build_segmented_tree(start, mid, arr, 2 * current + 1); 
        int right = build_segmented_tree(mid+1, end, arr, 2 * current + 2);
        
        tree[current] = Math.min(left, right);
        return tree[current];

    }

    public int getMin(int n, int query_start, int query_end){
        return getMinUtils(0, n-1, query_start, query_end, 0);
    }

    private int getMinUtils(int start, int end, int query_start, int query_end, int current) {
        if(query_start <= start && query_end >= end){
            return tree[current];
        }

        if(query_end < start || query_start > end) return Integer.MAX_VALUE;

        int mid = (start + end) / 2;
        return Math.min(
            getMinUtils(start, mid, query_start, query_end, 2 * current + 1),
            getMinUtils(mid+1, end, query_start, query_end, 2 * current + 2)
        );
    }

    public void updateValue(int[] arr, int value, int index){
        arr[index] = value;

        updateValueUtil(value, index, 0, arr.length-1, 0);
    }

    private void updateValueUtil(int diff, int index, int start, int end, int current) {
        if(index < start || index > end) return;

        tree[current] = Math.min(tree[current], diff);

        if(start != end){
            int mid = (start + end)/ 2;
            updateValueUtil(diff, index, start, mid, 2 * current + 1);
            updateValueUtil(diff, index, mid+1, end, 2 * current + 2);
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 30};
        int n = arr.length;

        SegmentTreeMin st = new SegmentTreeMin(arr, n);
        System.out.println("Segmented Tree " + Arrays.toString(st.tree));
        System.out.println("Min " + st.getMin(n, 1, 2));
        st.updateValue(arr, 1, 1);
        System.out.println(Arrays.toString(arr));
        System.out.println("Min " + st.getMin(n, 0, 2));
    }
}
