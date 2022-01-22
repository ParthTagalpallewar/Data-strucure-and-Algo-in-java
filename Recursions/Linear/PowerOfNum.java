package Recursions.Linear;

public class PowerOfNum {
    public static void main(String[] args) {
        int power = power(2, 3);
        System.out.println(power);
    }

    public static int power(int base, int n){
        if(n == 0) return 1;

        if(n == 1) return base;

        int half = power(base, n/2); //bring to lowest level
        int sq = half * half ; 

        if(n % 2 == 1){
            sq *= half;
        }

        return sq;

    }
}
