package Recursions.Linear;

public class NumOfDigits {
    
    public static void main(String[] args) {

        int digits = countDigits(10);
        System.out.println("Number of digits are " + digits);


    }

    public static int countDigits(int num){
        int digits = 1;
        int division = num / 10;

        if(division == 0) return 1;

        return digits + countDigits(division);


    }
}
