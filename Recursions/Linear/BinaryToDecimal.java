package Recursions.Linear;

public class BinaryToDecimal {
    public static void main(String[] args) {
        String reminder = DtoB(20);
        System.out.println(reminder );

        int binary = findBinary(20);
        System.out.println("Binary "+ binary);
    }

    public static String DtoB(int num){

        if(num < 2) return String.valueOf(num);

        int reminder = num % 2;
        int dividend =  num / 2;

        if(dividend == 1) return "1" + reminder;

        return DtoB(dividend) + reminder;
    }

    public static int findBinary(int num){

        if(num == 0) return 0;

        int binary = num % 2 + 10 * findBinary(num / 2);
        return binary;


    }

    
}
