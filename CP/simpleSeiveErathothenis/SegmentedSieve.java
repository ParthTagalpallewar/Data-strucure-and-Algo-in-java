package CP.simpleSeiveErathothenis;

import java.util.ArrayList;
import java.util.Arrays;

public class SegmentedSieve {
    public static void main(String[] args) {
        segmentedSieve(20);
    }

    public static void simpleSieve(int n, ArrayList<Integer> arr){
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);

        for(int i = 2; i*i <= n; i++){
            if(prime[i]){
                for(int j=i*i; j < n; j += i){
                    prime[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if(prime[i]) arr.add(i);
        }
    }

    public static void segmentedSieve(int n){
        
        int limit = (int) (Math.floor(Math.sqrt(n)) + 1);
        ArrayList<Integer> arr = new ArrayList<Integer>();

        simpleSieve(limit, arr);

        int low = limit;
        int high = 2*limit;

        while(low < n){

            high = Math.max(n, high);

            boolean[] mark = new boolean[limit+1];
            Arrays.fill(mark, true);

            for(int i=0; i < arr.size(); i++){
                int loLim = (int) (Math.floor(low / arr.get(i)) * arr.get(i));
                if (loLim < low)
                    loLim += arr.get(i);

                for (int j = loLim; j < high; j += arr.get(i))
                    mark[j - low] = false;
            }

            for (int i = low; i < high; i++)
                if (mark[i - low] == true)
                    System.out.print(i + "  ");

            // Update low and high for next segment
            low = low + limit;
            high = high + limit;

        }

    }
}
