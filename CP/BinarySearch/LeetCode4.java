package CP.BinarySearch;

public class LeetCode4 {
    
    public static double medianOfSortedArray(int[] A, int[] B){

        //keep A size always smaller than B
        if(A.length > B.length){
            return medianOfSortedArray(B, A);
        }

        int N1 = A.length, N2 = B.length;

        int low = 0, hi = N1;

        double median = 0.0;

        while(low <= hi){

            int i1 = (hi + low) / 2;
            int i2 = (N1 + N2 + 1)/2 - i1;

            int upperLeft = (i1 == 0) ? Integer.MIN_VALUE : A[i1-1];  
            int upperRight = (i1 == N1) ? Integer.MAX_VALUE : A[i1];

            int lowerLeft = (i2 == 0) ? Integer.MIN_VALUE : B[i2-1];
            int lowerRight = (i2 == N2) ? Integer.MAX_VALUE : B[i2];

             if((upperLeft <= lowerRight) && (lowerLeft <= upperRight)){

                if((N1 + N2) % 2 == 0){
                    int leftMax = Integer.max(upperLeft, lowerLeft);
                    int rightMin = Integer.min(upperRight, lowerRight);

                    median =  (double)(leftMax + rightMin)/2;
                }else{

                    median =  Integer.max(upperLeft, lowerLeft);
                }

                break;

            }

            else if(upperLeft > lowerRight){
                hi = i1 - 1;
            }

            else{
                low = i1 + 1;
            }

            
        }

        return median;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40, 50};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        double median = medianOfSortedArray(arr1, arr2);

        System.out.println("Median is " + median);
    }
}
