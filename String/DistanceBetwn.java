package String;

public class DistanceBetwn {

    public static void main(String[] args) {
        String str = "xyx";
        int dist = strDist(str, "z");

        System.out.println(dist);
    }

    public static int strDist(String str, String sub) {
     
        if(str.length() == 0) {
            return 0;
        }

        if (str.substring(0, sub.length()).equals(sub) == false) {
            System.out.println(str.substring(0, sub.length()) + " != " + sub);
            return strDist(str.substring(1), sub);

        }

        if (!str.substring(str.length() - sub.length(), str.length()).equals(sub)) {
            System.out.println(str.substring(str.length()-sub.length()) + " != " + sub);
            return strDist(str.substring(0, str.length() - 1), sub);
        }

        return str.length(); // base case
        
       
            

       
    }

}
