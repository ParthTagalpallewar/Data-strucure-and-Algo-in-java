package CP.simpleSeiveErathothenis;

import java.util.*;

// https://www.geeksforgeeks.org/sieve-of-eratosthenes/

public class SieveErothothenis {

    public static void main(String[] args) {
        sieveOfEratosthenes(100);
    }

    public static void sieveOfEratosthenes(int n){

        boolean prime[] = new boolean[n+1];
        Arrays.fill(prime, true);

        for(int i = 2; i*i <= n; i += 1){
            if(prime[i]){
                for(int j = i*i; j < n; j += i){
                    prime[j] = false;
                }
            }
        }

        //print all prime numbers
        for(int i = 2; i < n; i++){
            if(prime[i])System.out.println(i);
        }
    } 
    
}


