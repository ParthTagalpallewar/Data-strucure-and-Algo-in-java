package Tree.Tree.SegmentTree;

import java.util.Arrays;

public class SegmentedXor {
    int[] tree;
    
    public SegmentedXor(int arr[], int n){
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        int max_size = 2 * (int) Math.pow(2, x) - 1;

        tree = new int[max_size];

        build_segmented_tree(arr, 0, n-1, 0);
    }

    private int build_segmented_tree(int[] arr, int start, int end, int current) {
        if(start == end){
            tree[current] = arr[start];
            return arr[start];
        }

        int mid = (start + end) / 2;

        int left = build_segmented_tree(arr, start, mid, 2 * current + 1);
        int right = build_segmented_tree(arr, mid+1, end, 2 * current + 2);

        tree[current] = left ^ right;
        return tree[current];
    }

    public int getXor(int n, int query_start, int query_end){
        return getXorUtils(query_start, query_end, 0, n-1, 0);
    }

    private int getXorUtils(int query_start, int query_end, int start, int end, int current) {
        if(query_start <= start && query_end >= end){
            return tree[current];
        }

        if(query_end < start || query_start > end){
            return 0;
        }

        int mid = (start + end) / 2;

        return getXorUtils(query_start, query_end, start, mid,2 * current + 1) ^ getXorUtils(query_start, query_end, mid+1, end, 2 * current + 2);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5};
        int n = arr.length;

        SegmentedXor st = new SegmentedXor(arr, n);
        System.out.println("Segmented Tree " + Arrays.toString(st.tree));
        int xor = st.getXor(n, 0, 4);
        System.out.println("xor bet is " + xor);
    }

    
}
