//find first and last position in sorted array
package CP.BinarySearch;

public class LeetCode34 {
    public int[] searchRange(int[] arr, int target) {

        int[] result = { -1, -1 };

        if (arr.length == 0) {
            return result;
        }

        int left = 0, right = arr.length - 1;

        // find left most target element
        while (left < right) {

            int mid = (left + right) / 2;

            if (arr[mid] < target)
                left = mid + 1;

            else
                right = mid;
        }

        if (arr[left] != target)
            return result;
        result[0] = left;

        right = arr.length - 1;
        // find right most target element
        while (left < right) {
            int mid = (left + right) / 2 + 1;

            if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid;
        }

        result[1] = right;
        return result;

    }
}
