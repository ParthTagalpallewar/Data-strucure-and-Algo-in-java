package Recursions.Linear;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("","Hello"));
    }

    public static String reverse(String start, String str){
        
        if(str.length() == 0) return start;

        return reverse(Character.toString(str.charAt(0)), str.substring(1)) + start;
    }
}
