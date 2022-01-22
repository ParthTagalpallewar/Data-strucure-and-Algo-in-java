package Recursions.Linear;

public class Palindrome {
    public static void main(String[] args) {
        String data = "abcddcba";
        Boolean isPalindrome = checkPalindrome(data, 0, data.length()-1);
        System.out.println(isPalindrome);
    }

    public static Boolean checkPalindrome(String data, int start, int end){

        int n = data.length();

        if(n % 2 == 0 && start > end) return true;
        
        if(n % 2 != 0 && start == end) return true;

        if(data.charAt(start) != data.charAt(end)) return false;

        return checkPalindrome(data, start+1, end-1);


    }
}
