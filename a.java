/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();

        while (testcases-- > 0) {
            // size of poerty in pages
            int total_poetry_size = sc.nextInt();

            // size of remaining pages in current book
            int remaing_pages = sc.nextInt();

            // total money
            int total_money = sc.nextInt();

            // number of notebooks shown by shopkeeper
            int total_books_count = sc.nextInt();

            boolean isBookFound = false;

            for (int i = 0; i < total_books_count; i++) {

                int book_pages_count = sc.nextInt();
                int book_cost = sc.nextInt();

                int min_pages_need = total_poetry_size - remaing_pages;

                // if(min_pages_need <= book_pages_count && total_money >= book_cost){
                // isBookFound = true;
                // }

                if (min_pages_need > book_pages_count || book_cost > total_money)
                    continue;

                System.out.println("LuckyChef");
                isBookFound = true;
                break;

            }

            if (!isBookFound)
                System.out.println("UnluckyChef");
            // else System.out.println("LuckyChef");
        }

    }
}
