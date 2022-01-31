class SegmentTreeSum {
    int tree[]; // The array that stores segment tree nodes

    SegmentTreeSum(int arr[], int n) {

        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        int max_size = 2 * (int) Math.pow(2, x) - 1;

        tree = new int[max_size]; // Memory allocation

        constructSTUtil(arr, 0, n - 1, 0);
    }

    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    int getSumUtil(int start, int end, int query_start, int query_end, int current) {

        if (query_start <= start && query_end >= end)
            return tree[current];

        if (end < query_start || start > query_end)
            return 0;

        int mid = getMid(start, end);
        
        int left = getSumUtil(start, mid, query_start, query_end, 2 * current + 1);
        int right = getSumUtil(mid + 1, end, query_start, query_end, 2 * current + 2);

        return left + right;

    }

    int getSum(int n, int query_start, int query_end) {
        // Check for erroneous input values
        if (query_start < 0 || query_end > n - 1 || query_start > query_end) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, query_start, query_end, 0);
    }

    private int constructSTUtil(int arr[], int start, int end, int current) {

        if (start == end) {
            tree[current] = arr[start];
            return arr[start];
        }

        int mid = getMid(start, end);
        tree[current] = constructSTUtil(arr, start, mid, current * 2 + 1) +
                constructSTUtil(arr, mid + 1, end, current * 2 + 2);
        return tree[current];
    }

    public static void main(String args[]) {

        int[] tree = { 10, 20, 30 };
        SegmentTreeSum st = new SegmentTreeSum(tree, tree.length);

        int sum = st.getSum(tree.length, 0, 1);
        System.out.println(sum);
    }
}