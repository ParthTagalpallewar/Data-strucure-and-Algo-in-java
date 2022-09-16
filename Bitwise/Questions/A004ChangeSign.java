package Bitwise.Questions;

// twos complement of any number will change the sign of given number


public class A004ChangeSign {
    public static void main(String[] args) {
        
        int a = -200;

        // ~(a-1) = (~a)+1
        int b = ~(a-1);
        int c = ~(a)+1;
 

        System.out.println(b);
        System.out.println(c);

    }
}
