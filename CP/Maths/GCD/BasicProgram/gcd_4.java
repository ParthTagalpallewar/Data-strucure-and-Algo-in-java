package CP.Maths.GCD.BasicProgram;

public class gcd_4 {
    public static void main(String[] args) {
        int a = 5;
        int b = 9;

        System.out.println(gcd(a, b));
        System.out.println(gcd2(a, b));
    }

    public static int gcd(int a, int b) {

        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int r = 0;

        if(max%min == 0) return min;

        while(max%min != 0){
            r = max%min;
            max = min;
            min = r;
        }

        return r;
        
    }

    public static int gcd2(int a, int b){
        if(b == 0) return a;

        return gcd(b, a%b);
    }
}
