package CP.Maths.A003NumberSystem.A002GCD.BasicProgram;

public class gcd_1 {
    public static void main(String[] args) {
        
        int a = 10;
        int b = 100;

        System.out.println(gcd(a, b));

    }  
    
    public static int gcd(int a, int b){
        int gcd = 1;

        for(int i=1; i<=Math.min(a, b); i++){
            if(a%i == 0 && b%i == 0) gcd = i;
        }

        return gcd;
    }
}
