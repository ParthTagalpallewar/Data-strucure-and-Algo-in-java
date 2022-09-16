package CP.Maths.A004BinomialCoefficient;

import java.util.Arrays;

// nCr = nC(n-r)
// 4C0 = 1, 4C1 = 4, 4C2 = 6, 4C3=4, 4C4=0

// so if we are asked for 4C3 we can calculate ans for 4C1

// 4C2
// 1 0 0
// 1 1 0
// 1 2 1
// 1 3 3
// 1 4 6

public class A002PascalTriangle {

    public static void main(String[] args) {
        int ans = nCr(4, 2);
        System.out.println(ans);
    }

    
    // time complexity => O(n*r)
    // space complexity => O(r)

    public static int nCr(int n, int r){

        if(r > n) return 0;

        r = Math.min(r, n-r);
        int mod = 1000000007;

        int[] arr = new int[r+1];
        Arrays.fill(arr, 0);
        
        arr[0] = 1;

        for(int i=1; i<=n; i++){

            for(int j=Math.min(i, r); j>0; j--){
                arr[j] = ((arr[j]%mod) + (arr[j-1]%mod))%mod;
            }

        }

        return arr[r];


    }


}
