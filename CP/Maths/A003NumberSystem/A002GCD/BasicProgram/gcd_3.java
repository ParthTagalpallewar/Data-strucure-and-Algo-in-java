package CP.Maths.A003NumberSystem.A002GCD.BasicProgram;

public class gcd_3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 100;

        System.out.println(gcd(a, b));
    }

    public static int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
