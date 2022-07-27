/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            System.out.println(solve(s));
        }
    }

    public static int solve(String s) {

        boolean isU = s.charAt(0) == 'U';

        int u_count = isU ? 1 : 0;
        int s_count = isU ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {

            char curr_char = s.charAt(i);

            if (isU) {

                if (curr_char == 'U')
                    continue;

                s_count += 1;

            }

            else {
                if (curr_char == 'D')
                    continue;

                u_count += 1;

            }

            isU = !isU;

        }

        return Math.min(u_count, s_count);
    }
}