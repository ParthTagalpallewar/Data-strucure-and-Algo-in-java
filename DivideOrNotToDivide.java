/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();

            if (a == b)
                System.out.println(-1);

            else if (n % a == 0 && n % b != 0)
                System.out.println(n);

            else {

                int count = 0;
                int firstNumber = (n / a) * a;
                if (firstNumber < n)
                    firstNumber += a;

                while (count < 100 && firstNumber % b == 0) {
                    firstNumber += a;
                    count += 1;
                }

                if (count == 100) {
                    System.out.println(-1);
                    continue;
                }

                System.out.println(firstNumber);

            }
        }
    }
}
