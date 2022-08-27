package Bitwise.Questions;

public class A001calculateSetBits {
    public static void main(String[] args) {
        
        int a = 3;
        System.out.println(setBits(a));
        System.out.println(brian_kerninghan(a));

    }
    // Method 1
    // to check if last bit is 1 or 0
    // we are using AND operator which will give 1 if last bit is 1 and 0 is last bit is 0
    // we are using right shift which will half the value (shift bit ro right)
    public static int setBits(int n){

        int setBits = 0;
        while(n > 0){
            if((n & 1) == 1) setBits += 1;
            n >>= 1;
        }

        return setBits;

    }

    //Method 2
    // when we do n & (n-1) this will change first 1 from left side to 0 
    // so we are going to repeat this till n > 0
    public static int brian_kerninghan(int n){
        int setBits = 0;

        while(n > 0){
            n &= (n-1);
            setBits += 1;
        }

        return setBits;
    }

    public static int builtInMethod(int n){
        return Integer.bitCount(n);
    }
}
