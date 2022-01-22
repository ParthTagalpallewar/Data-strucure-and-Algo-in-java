package Recursions;

public class GreatestCommonFactor {
    
    public static void main(String[] args) {
        int gcf = greatestCommonFactor(10, 50);
        System.out.println("GCF " + gcf);

        
    }

    public static int greatestCommonFactor(int a, int b){
        if(a > b) return greatestCommonFactor(b, a); // taking a as always small

        int reminder = b % a;

        if(reminder == 0) return a;

        return greatestCommonFactor(a, reminder);
    }

}
