package Bitwise.XOR;

// question :- given an array and each element in array is repeated exactly twice expect one 
//              print the element which frequency is one

// Example -> {1, 2, 2, 3, 3} ans -> 1

public class A001 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 3 };
        int ans = 0;

        for (int a : arr) {
            ans ^= a;
        }

        System.out.println(ans);

    }
}
