package CP.Maths.GCD.BasicProgram;

public class gcd_2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 100;

        System.out.println(gcd(a, b));
    }   

    public static int gcd(int a, int b){

        while(a!=b){
            if (a > b)
                a = a - b;

            else
                b = b - a;
        }
    
        return b;
    }
}
