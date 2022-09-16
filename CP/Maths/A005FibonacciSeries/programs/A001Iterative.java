package CP.Maths.A005FibonacciSeries.programs;

import java.util.HashMap;

public class A001Iterative {

    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        
        for (int i = 0; i < 15; i++) {
            System.out.println("f(" + i + ") = " + nthFiboNumber(i));
        }
    }


    public static int nthFiboNumber(int n){

        int mod = 1000000007;

        if(n < 2) return n;
        
        if(map.containsKey(n)) return map.get(n);

        int val1 = nthFiboNumber(n-1);
        map.put(n-1, val1);

        int val2 = nthFiboNumber(n-2);
        map.put(n-2, val2);

        return ((val1%mod)+(val2%mod))%mod;
    } 
}

