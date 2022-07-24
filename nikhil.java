/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int ans = 0;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {

                int curr = arr[i];

                if (curr == 0) {
                    ans += (count * (count + 1)) / 2;
                    count = 0;
                    continue;
                }

                if (curr == 1) {
                    count += 1;
                }

            }
            if (count != 0) {
                ans += (count * (count + 1)) / 2;
            }

            System.out.println(ans);
        }
    }
}
