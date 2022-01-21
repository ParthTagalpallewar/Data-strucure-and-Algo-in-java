package String;

public class NestedParenthsisCheck {
    public static void main(String[] args) {

        String syntax = "(())";
        boolean isCorrect = nestParen(syntax);
        System.out.println(isCorrect);

    }

    public static boolean nestParen(String str) {
        if (str.length() == 0)
            return true;

        // if first and last char are equal
        if (str.charAt(0) == '(' && ')' == str.charAt(str.length() - 1)) {
            return nestParen(str.substring(1, str.length() - 1));
        }

        return false;

    }
}
