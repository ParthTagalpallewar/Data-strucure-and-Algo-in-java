
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        
        int[] arr = {0, 1, 0, 0, 1, 0, 1, 1, 0, 1};

        long ans = 0;
        int count = 0;
        for(int i=0; i < arr.length; i++){

            int curr = arr[i];

            if(curr == 0) {
                ans += (count * (count+1))/2;
                count = 0;
                continue;
            }

            if(curr == 1){
                count += 1;
            }

        }
        if(count != 0){
            ans += (count * (count + 1)) / 2;
        }

        System.out.println(ans);
        
    }
}