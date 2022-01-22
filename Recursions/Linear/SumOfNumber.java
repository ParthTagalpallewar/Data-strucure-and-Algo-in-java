package Recursions.Linear;

public class SumOfNumber {
    
    public static void main(String[] args) {
        int sum = sumOfDigits(125);
        System.out.println("Sum of digit is " + sum);
    }

    public static int sumOfDigits(int number){
     
        int digit = number % 10;
        number /= 10;

        if(number == 0) return digit;

        return digit + sumOfDigits(number);

        
    }
}
