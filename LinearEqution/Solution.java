package LinearEqution;

public class Solution {
    public static void main(String[] args) {

        int a, b, c, d, m, n, z;
        a = 2;
        b = 10;
        c = 1;
        d = 1;
        m = 12;
        n = 4;
        System.out.println("1st linear equation is=>  " + a + "x1 +" + b + "x2=" + m);
        System.out.println("2ed linear equation is=>  " + c + "x1 +" + d + "x2=" + n);
        System.out.println("using formula and we get the val of x1 & x2 as:");
        z = (a * d) - (c * b);
        if (z == 0) {
            System.out.println("************the denominator (a*d)-(c*b) is not equal to zero");
        } else {
            int x1 = (m * d - b * n) / (a * d - c * b);
            if((m * d - b * n) % (a * d - c * b) != 0){
                x1 += 1;
            }
            
            int x2 = (int) n-x1;

            
            System.out.println("           x1=" + x1);
            System.out.println("           x2=" + x2);
        }
    }
}
