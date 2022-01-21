package String;

public class ParenBit {
    public static void main(String[] args) {
        // String abc = "abc(abc)abc";

        // String parenBit = parenBit(abc);
        // System.out.println(parenBit);

        String syntax = "(())";
        boolean isCorrect = nestParen(syntax);
        System.out.println(isCorrect);

    }

    public static String parenBit(String str) {
        if (str.charAt(0) != '(') {
            return parenBit(str.substring(1));
        }
        if (str.charAt(str.length()-1) != ')') {
            return parenBit(str.substring(0, str.length()-1));
        }
        return str;
    }

    public static boolean nestParen(String str) {
        if (str.length() == 0)
            return true;
        
        // System.out.println(str.charAt(0) str.charAt(str.length() - 1));
        // if first and last char are equal
        if (str.charAt(0) == '(' && ')' == str.charAt(str.length() - 1)) {
            return nestParen(str.substring(1, str.length() - 1));
        }

        return false;

    }
}
