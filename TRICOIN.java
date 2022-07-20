/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int coins = sc.nextInt();

            // check which row needs how many coins
            int low = 1;
            int high = coins;
            int ans = 0;

            while (low <= high) {

                int middle_row = low + (high - low) / 2;
                int middle_row_coins = (middle_row * (middle_row + 1)) / 2;

                if (middle_row_coins <= coins) {
                    ans = middle_row;
                    low = middle_row + 1;
                } else {
                    high = middle_row - 1;
                }

            }

            System.out.println(ans);

        }
    }
}