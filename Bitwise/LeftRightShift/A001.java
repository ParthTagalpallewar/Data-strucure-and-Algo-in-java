package Bitwise.LeftRightShift;

public class A001 {
    public static void main(String[] args) {
        int a = 2;

        for(int i=0; i<5; i++){
            a = a << 2;
            System.out.println(a);
        }

        int b = 100;
        for(int i=0; i<3; i++){
            b = b >> 1;
            System.out.println(b);
        }
    }
}
