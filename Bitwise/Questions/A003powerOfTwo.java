package Bitwise.Questions;

public class A003powerOfTwo {
    public static void main(String[] args) {
        
        for (int i = 0; i < 50; i++) {
            // Method one 
            // if(isPowerOf2(i))
            //     System.out.println(i);

            // method 2
            if(Integer.bitCount(i) == 1) System.out.println(i);
        }

        
        
    }

    public static boolean isPowerOf2(int n){
        int a = n & (n-1);
        if(n != 0 && a == 0){
            return true;
        }

        return false;
    }
}
