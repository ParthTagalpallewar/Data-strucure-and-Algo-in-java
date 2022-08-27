package Bitwise.Questions;

public class A002ODDorEven {
    public static void main(String[] args) {
       for(int i=0; i<10; i++){
        if(isEven(i)) System.out.println(i + " even ");

        else System.out.println(i + " odd ");
       } 
    }
    
    // if number is even its last bit is 0 
    // if number is odd its last bit is 1
    // and when any number get & 1 it returns its last bit 
    public static boolean isEven(int n){
        if((n & 1) == 0) return true;

        return false;
    }
}
