package Bitwise.Questions;

// Question -> Given a array of 2*N+2 elements where 2*N element are same and 2 element are different.
// Topic 
// to find rightmost set bit do (num & -num)
// 12 (1100) & -12 (0100) -> (0100)

// Algorithm

// Array -> {1, 2, 3, 4, 2, 1}

// step 1 -> xor of all elements -> 3(0011) ^ 4(0100) -> 7(0111) 
// step 2 -> find first set bit of xor num -> (num & -num) -> 7(0111) & -7(1001) = 1(0001)
// step 3 -> find the element in array whose set bit is 1 at 0 position using and operator
// step 4 -> take a xor of element whose matches step 3 condition




public class A005FindTwoDistintNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 1};

        // step 1: xor of all elements -> 3(0011) ^ 4(0100) -> 7(0111)
        int xor = 0;
        for(int i: arr) xor ^= i;

        // step 2: // step 2 -> find first set bit of xor num -> (num & -num) -> 7(0111)
        // & -7(1001) = 1(0001)
        int rmsb = xor & (-xor);


        int a = 0;
        int b = 0;

        // step 3 -> find the element in array whose set bit is 1 at 0 position using
        // and operator
        for(int i: arr){

            // if and operation gives num greater than zero
            if((i & rmsb) > 0){
                a ^= i;
            }else{
                b ^= i;
            }

        }

        System.out.println(a + " " + b);

    }
}
