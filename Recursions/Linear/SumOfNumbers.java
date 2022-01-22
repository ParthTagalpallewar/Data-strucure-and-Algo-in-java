package Recursions;

public class SumOfNumbers {
    
    public static void main(String[] args) {
        
        // int sumOfNumbers = sumOfN(5);
        // System.out.println(sumOfNumbers);
       
        int fibo = fibo(5, 0);
        System.out.println(fibo);



    }

    public static int sumOfN(int n){

        if( n == 1) return 1;

        return n + sumOfN(n-1);

    }

    public static int fibo(int limit, int r){

        if(limit < 2){
            System.out.println(limit + " - " + r);
            return limit;
        } 

        else{
            System.out.println(limit + " " + r);
            return fibo(limit - 1, 1) + fibo(limit - 2, 2);
        } 

    }



}
